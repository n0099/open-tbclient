package d.a.c0.k.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
/* loaded from: classes2.dex */
public class e extends Handler {
    public e() {
        super(Looper.getMainLooper());
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        f fVar = (f) message.obj;
        ImageView imageView = fVar.f43076a;
        if (((String) imageView.getTag()).equals(fVar.f43077b)) {
            imageView.setImageBitmap(fVar.f43078c);
        } else {
            d.a.c0.n.d.e("不是最新数据");
        }
    }
}
