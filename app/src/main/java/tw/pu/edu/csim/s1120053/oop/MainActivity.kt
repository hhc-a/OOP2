package tw.pu.edu.csim.s1120053.oop

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(),OnClickListener,OnLongClickListener {
    lateinit var txv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txv = findViewById(R.id.txv)
//        txv.text = "OOP example"
//        var v1=two()
//        v1.x=7
//        v1.y=5
//        var v2=two()
//        v2.x=55
//        v2.y=7
//        var v3=two(46,8)
        var v3= two.three(55, 6, 21)
        txv.text=v3.Sum().toString()+"\n"+v3.Avg().toString()
        var img:ImageView=findViewById(R.id.img)
        img.setOnClickListener(this)
        txv.setOnClickListener(this)
        img.setOnLongClickListener(this)
    }

    override fun onClick(v:View?) {
         txv = findViewById(R.id.txv)
        var img:ImageView=findViewById(R.id.img)
        if(v==txv){
            txv.text="咩咩"
        }else {
            txv.text = "是一隻羊"
        }
    }

    override fun onLongClick(p0: View?): Boolean {
        txv = findViewById(R.id.txv)
        txv.text="草呢"
        return true
    }
}
interface Average{
    fun Avg():Float
}
open class two(var x:Int,var y:Int):Average {
    open fun Sum(): Int {
        return x + y
    }

    override fun Avg(): Float {
        return (x + y).toFloat() / 2
    }

    class three(x: Int, y: Int, var z: Int) : two(x, y), Average {
        override fun Sum(): Int {
            return x + y + z
        }

        override fun Avg(): Float {
            return (x + y + z).toFloat() / 3
        }
    }
}