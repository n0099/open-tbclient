package d.b.j0.s3.b;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tieba.videoplay.editor.VideoPlayInputContainer;
import d.b.i0.w.m;
/* loaded from: classes5.dex */
public class c extends m {
    public EditText q;

    public c(Context context) {
        super(context, (String) null, 28);
        this.m = false;
        this.l = 3;
        VideoPlayInputContainer videoPlayInputContainer = new VideoPlayInputContainer(context);
        this.k = videoPlayInputContainer;
        this.q = videoPlayInputContainer.getInputView();
        this.n = new int[]{4, 24, 3, 9, 6};
    }

    public EditText g() {
        return this.q;
    }
}
