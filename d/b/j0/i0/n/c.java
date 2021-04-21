package d.b.j0.i0.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f57382a;

    /* renamed from: b  reason: collision with root package name */
    public View f57383b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f57384c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f57385d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57386e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57387f;

    public c(TbPageContext<?> tbPageContext) {
        this.f57382a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.f57383b = inflate;
        this.f57384c = (ViewGroup) inflate.findViewById(R.id.item_group);
        this.f57385d = (ImageView) this.f57383b.findViewById(R.id.image);
        this.f57386e = (TextView) this.f57383b.findViewById(R.id.hint_text_1);
        this.f57387f = (TextView) this.f57383b.findViewById(R.id.hint_text_2);
        this.f57386e.setText(R.string.no_like_forum_hint_1);
        this.f57387f.setText(R.string.no_like_forum_hint_2);
    }

    public void a() {
        SkinManager.setImageResource(this.f57385d, R.drawable.cp_mask_attention_a);
        SkinManager.setViewTextColor(this.f57386e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f57387f, R.color.CAM_X0109);
        TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0206).tlRadius(l.g(this.f57382a.getPageActivity(), R.dimen.tbds21)).trRadius(l.g(this.f57382a.getPageActivity(), R.dimen.tbds21)).blRadius(l.g(this.f57382a.getPageActivity(), R.dimen.tbds21)).brRadius(l.g(this.f57382a.getPageActivity(), R.dimen.tbds21)).into(this.f57384c);
    }

    public View b() {
        return this.f57383b;
    }
}
