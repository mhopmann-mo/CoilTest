package ru.beryukhov.coiltest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberImagePainter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val url = "https://clipart-db.ru/file_content/rastr/leopard_008.png"
            Column() {
                Text("Working")
                Image(painter = rememberImagePainter(
                    data = url,
                    builder = {
                        placeholder(R.drawable.ic_launcher_background)
                    }
                ),
                    contentDescription = "",
                    modifier = Modifier.height(200.dp)
                )
                Text("Not working")
                ConstraintLayout(Modifier) {
                    val (ivBackgroundPoster) = createRefs()
                    Image(painter = rememberImagePainter(
                        data = url,
                        builder = {
                            placeholder(R.drawable.ic_launcher_background)
                        }
                    ),
                        contentScale = ContentScale.Crop,
                        contentDescription = "",
                        modifier = Modifier.constrainAs(ivBackgroundPoster) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints//probably this brokes
                        }
                    )
                }
            }
        }
    }
}
