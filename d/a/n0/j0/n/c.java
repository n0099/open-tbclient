package d.a.n0.j0.n;

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
    public TbPageContext<?> f59901a;

    /* renamed from: b  reason: collision with root package name */
    public View f59902b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f59903c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f59904d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59905e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59906f;

    public c(TbPageContext<?> tbPageContext) {
        this.f59901a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.f59902b = inflate;
        this.f59903c = (ViewGroup) inflate.findViewById(R.id.item_group);
        this.f59904d = (ImageView) this.f59902b.findViewById(R.id.image);
        this.f59905e = (TextView) this.f59902b.findViewById(R.id.hint_text_1);
        this.f59906f = (TextView) this.f59902b.findViewById(R.id.hint_text_2);
        this.f59905e.setText(R.string.no_like_forum_hint_1);
        this.f59906f.setText(R.string.no_like_forum_hint_2);
    }

    public void a() {
        SkinManager.setImageResource(this.f59904d, R.drawable.cp_mask_attention_a);
        SkinManager.setViewTextColor(this.f59905e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f59906f, R.color.CAM_X0109);
        TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0206).tlRadius(l.g(this.f59901a.getPageActivity(), R.dimen.tbds21)).trRadius(l.g(this.f59901a.getPageActivity(), R.dimen.tbds21)).blRadius(l.g(this.f59901a.getPageActivity(), R.dimen.tbds21)).brRadius(l.g(this.f59901a.getPageActivity(), R.dimen.tbds21)).into(this.f59903c);
    }

    public View b() {
        return this.f59902b;
    }
}
