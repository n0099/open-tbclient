package d.b.j0.a1.j.a.e;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer;
import d.b.i0.w.m;
/* loaded from: classes4.dex */
public class c extends m {
    public EditText q;

    public c(Context context) {
        super(context, (String) null, 29);
        this.m = false;
        this.l = 3;
        TopicDetaiInputContainer topicDetaiInputContainer = new TopicDetaiInputContainer(context);
        this.k = topicDetaiInputContainer;
        this.q = topicDetaiInputContainer.getInputView();
        ((TopicDetaiInputContainer) this.k).setHint(context.getString(R.string.say_your_point));
        this.n = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText g() {
        return this.q;
    }
}
