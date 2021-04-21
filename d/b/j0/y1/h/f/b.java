package d.b.j0.y1.h.f;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class b extends d.b.j0.y1.h.f.g.a {

    /* renamed from: a  reason: collision with root package name */
    public View f64597a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f64598b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f64599c;

    public b(View view, String str) {
        this.f64597a = view;
        TextView textView = (TextView) view.findViewById(R.id.emotion_empty_content);
        this.f64598b = textView;
        textView.setText(str);
        this.f64599c = (ImageView) view.findViewById(R.id.emotion_empty_icon);
        c();
    }

    public View a() {
        return this.f64597a;
    }

    public void b(int i) {
        TextView textView = this.f64598b;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107, i);
        }
        ImageView imageView = this.f64599c;
        if (imageView != null) {
            SkinManager.setImageResource(imageView, R.drawable.new_pic_emotion_02, i);
        }
        View view = this.f64597a;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0201, i);
        }
    }

    public final void c() {
        int i = l.i(TbadkCoreApplication.getInst());
        int dimensionPixelSize = i <= 0 ? TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds200) : (int) (i * 0.11d);
        ViewGroup.LayoutParams layoutParams = this.f64599c.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = dimensionPixelSize;
            this.f64599c.setLayoutParams(marginLayoutParams);
        }
    }
}
