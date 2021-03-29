package d.b.i0.i0.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f55838a;

    /* renamed from: b  reason: collision with root package name */
    public View f55839b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f55840c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f55841d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55842e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55843f;

    public c(TbPageContext<?> tbPageContext) {
        this.f55838a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.f55839b = inflate;
        this.f55840c = (ViewGroup) inflate.findViewById(R.id.item_group);
        this.f55841d = (ImageView) this.f55839b.findViewById(R.id.image);
        this.f55842e = (TextView) this.f55839b.findViewById(R.id.hint_text_1);
        this.f55843f = (TextView) this.f55839b.findViewById(R.id.hint_text_2);
        this.f55842e.setText(R.string.no_like_forum_hint_1);
        this.f55843f.setText(R.string.no_like_forum_hint_2);
    }

    public void a() {
        SkinManager.setImageResource(this.f55841d, R.drawable.cp_mask_attention_a);
        SkinManager.setViewTextColor(this.f55842e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f55843f, R.color.CAM_X0109);
        TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0206).tlRadius(l.g(this.f55838a.getPageActivity(), R.dimen.tbds21)).trRadius(l.g(this.f55838a.getPageActivity(), R.dimen.tbds21)).blRadius(l.g(this.f55838a.getPageActivity(), R.dimen.tbds21)).brRadius(l.g(this.f55838a.getPageActivity(), R.dimen.tbds21)).into(this.f55840c);
    }

    public View b() {
        return this.f55839b;
    }
}
