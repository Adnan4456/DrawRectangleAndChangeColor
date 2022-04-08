package com.example.customeviewrectangle

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.annotation.Nullable

class CustomRectangleView : View {

    private lateinit var rect:Rect
    private lateinit var paint:Paint

    private var squareColor:Int = 0
    private var squareSize:Int = 0

    private var SQUARE_SIZE_DEF:Int  = 300

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet): super(context , attrs){
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr:Int):
            super(context , attrs , defStyleAttr){
        init(attrs)
    }

    private fun init(@Nullable set: AttributeSet?){

        rect = Rect()
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
//        Paint.ANTI_ALIAS_FLAG is flag that is more user friendly



        //Now set custom attributes from XML file here
        if(set == null){
            return
        }
        var typedArray = context.obtainStyledAttributes(set , R.styleable.CustomRectangleView)

        //obtain color value from attribute.Through this we can set color
        //to rectangle through XML file.

        squareColor = typedArray.getColor(R.styleable.CustomRectangleView_square_color , Color.GREEN)
        squareSize = typedArray.getDimensionPixelSize(R.styleable.CustomRectangleView_square_size ,SQUARE_SIZE_DEF )

        Log.d("size = ","$squareSize")
        //setting color to rectangle
        paint.setColor(squareColor)
        typedArray.recycle()
    }

     fun swapColor(){

         if(paint.color == squareColor){
//            Log.d("Color = ","Color.GREEN")
            paint.setColor(Color.RED)
        }
        else{
            paint.setColor(squareColor )
//            Log.d("Color = ","Color.RED")
        }

         //Now set this change on canvas for that we can use
         //invalide() method run on main thread and block UI (not recommended)

        //prefer this method not block UI.
         postInvalidate()

    }
    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
        //Add background color of View
//        canvas!!.drawColor(Color.RED)

        //setting the values of rectangle
        rect.left = 100
        rect.top = 100
        rect.right =  rect.left + SQUARE_SIZE_DEF
        rect.bottom =  rect.top + SQUARE_SIZE_DEF


        //Now draw the rectangle on View
        canvas!!.drawRect(rect , paint)

    }
}
