package d.a.n0.z1.h.f;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class b extends d.a.n0.z1.h.f.g.a {

    /* renamed from: a  reason: collision with root package name */
    public View f63766a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f63767b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f63768c;

    public b(View view, String str) {
        this.f63766a = view;
        TextView textView = (TextView) view.findViewById(R.id.emotion_empty_content);
        this.f63767b = textView;
        textView.setText(str);
        this.f63768c = (ImageView) view.findViewById(R.id.emotion_empty_icon);
        c();
    }

    public View a() {
        return this.f63766a;
    }

    public void b(int i2) {
        TextView textView = this.f63767b;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107, i2);
        }
        ImageView imageView = this.f63768c;
        if (imageView != null) {
            SkinManager.setImageResource(imageView, R.drawable.new_pic_emotion_02, i2);
        }
        View view = this.f63766a;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0201, i2);
        }
    }

    public final void c() {
        int i2 = l.i(TbadkCoreApplication.getInst());
        int dimensionPixelSize = i2 <= 0 ? TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds200) : (int) (i2 * 0.11d);
        ViewGroup.LayoutParams layoutParams = this.f63768c.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = dimensionPixelSize;
            this.f63768c.setLayoutParams(marginLayoutParams);
        }
    }
}
