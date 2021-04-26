package d.a.j0.i0.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f55321a;

    /* renamed from: b  reason: collision with root package name */
    public View f55322b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f55323c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f55324d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55325e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55326f;

    public c(TbPageContext<?> tbPageContext) {
        this.f55321a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.f55322b = inflate;
        this.f55323c = (ViewGroup) inflate.findViewById(R.id.item_group);
        this.f55324d = (ImageView) this.f55322b.findViewById(R.id.image);
        this.f55325e = (TextView) this.f55322b.findViewById(R.id.hint_text_1);
        this.f55326f = (TextView) this.f55322b.findViewById(R.id.hint_text_2);
        this.f55325e.setText(R.string.no_like_forum_hint_1);
        this.f55326f.setText(R.string.no_like_forum_hint_2);
    }

    public void a() {
        SkinManager.setImageResource(this.f55324d, R.drawable.cp_mask_attention_a);
        SkinManager.setViewTextColor(this.f55325e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f55326f, R.color.CAM_X0109);
        TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0206).tlRadius(l.g(this.f55321a.getPageActivity(), R.dimen.tbds21)).trRadius(l.g(this.f55321a.getPageActivity(), R.dimen.tbds21)).blRadius(l.g(this.f55321a.getPageActivity(), R.dimen.tbds21)).brRadius(l.g(this.f55321a.getPageActivity(), R.dimen.tbds21)).into(this.f55323c);
    }

    public View b() {
        return this.f55322b;
    }
}
