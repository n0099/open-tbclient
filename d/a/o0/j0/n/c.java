package d.a.o0.j0.n;

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
    public TbPageContext<?> f60026a;

    /* renamed from: b  reason: collision with root package name */
    public View f60027b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f60028c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f60029d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60030e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60031f;

    public c(TbPageContext<?> tbPageContext) {
        this.f60026a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.f60027b = inflate;
        this.f60028c = (ViewGroup) inflate.findViewById(R.id.item_group);
        this.f60029d = (ImageView) this.f60027b.findViewById(R.id.image);
        this.f60030e = (TextView) this.f60027b.findViewById(R.id.hint_text_1);
        this.f60031f = (TextView) this.f60027b.findViewById(R.id.hint_text_2);
        this.f60030e.setText(R.string.no_like_forum_hint_1);
        this.f60031f.setText(R.string.no_like_forum_hint_2);
    }

    public void a() {
        SkinManager.setImageResource(this.f60029d, R.drawable.cp_mask_attention_a);
        SkinManager.setViewTextColor(this.f60030e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f60031f, R.color.CAM_X0109);
        TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0206).tlRadius(l.g(this.f60026a.getPageActivity(), R.dimen.tbds21)).trRadius(l.g(this.f60026a.getPageActivity(), R.dimen.tbds21)).blRadius(l.g(this.f60026a.getPageActivity(), R.dimen.tbds21)).brRadius(l.g(this.f60026a.getPageActivity(), R.dimen.tbds21)).into(this.f60028c);
    }

    public View b() {
        return this.f60027b;
    }
}
