package d.b.i0.i0.n;

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
    public TbPageContext<?> f56961a;

    /* renamed from: b  reason: collision with root package name */
    public View f56962b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f56963c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f56964d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56965e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56966f;

    public c(TbPageContext<?> tbPageContext) {
        this.f56961a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.f56962b = inflate;
        this.f56963c = (ViewGroup) inflate.findViewById(R.id.item_group);
        this.f56964d = (ImageView) this.f56962b.findViewById(R.id.image);
        this.f56965e = (TextView) this.f56962b.findViewById(R.id.hint_text_1);
        this.f56966f = (TextView) this.f56962b.findViewById(R.id.hint_text_2);
        this.f56965e.setText(R.string.no_like_forum_hint_1);
        this.f56966f.setText(R.string.no_like_forum_hint_2);
    }

    public void a() {
        SkinManager.setImageResource(this.f56964d, R.drawable.cp_mask_attention_a);
        SkinManager.setViewTextColor(this.f56965e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f56966f, R.color.CAM_X0109);
        TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0206).tlRadius(l.g(this.f56961a.getPageActivity(), R.dimen.tbds21)).trRadius(l.g(this.f56961a.getPageActivity(), R.dimen.tbds21)).blRadius(l.g(this.f56961a.getPageActivity(), R.dimen.tbds21)).brRadius(l.g(this.f56961a.getPageActivity(), R.dimen.tbds21)).into(this.f56963c);
    }

    public View b() {
        return this.f56962b;
    }
}
