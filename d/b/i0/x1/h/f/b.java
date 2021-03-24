package d.b.i0.x1.h.f;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class b extends d.b.i0.x1.h.f.g.a {

    /* renamed from: a  reason: collision with root package name */
    public View f62490a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f62491b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f62492c;

    public b(View view, String str) {
        this.f62490a = view;
        TextView textView = (TextView) view.findViewById(R.id.emotion_empty_content);
        this.f62491b = textView;
        textView.setText(str);
        this.f62492c = (ImageView) view.findViewById(R.id.emotion_empty_icon);
        c();
    }

    public View a() {
        return this.f62490a;
    }

    public void b(int i) {
        TextView textView = this.f62491b;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107, i);
        }
        ImageView imageView = this.f62492c;
        if (imageView != null) {
            SkinManager.setImageResource(imageView, R.drawable.new_pic_emotion_02, i);
        }
        View view = this.f62490a;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0201, i);
        }
    }

    public final void c() {
        int i;
        int i2 = l.i(TbadkCoreApplication.getInst());
        if (i2 <= 0) {
            i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds200);
        } else {
            double d2 = i2;
            Double.isNaN(d2);
            i = (int) (d2 * 0.11d);
        }
        ViewGroup.LayoutParams layoutParams = this.f62492c.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.f62492c.setLayoutParams(marginLayoutParams);
        }
    }
}
