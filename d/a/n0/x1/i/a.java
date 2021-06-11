package d.a.n0.x1.i;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import d.a.m0.g0.d.b;
import java.util.Date;
/* loaded from: classes4.dex */
public class a extends d.a.m0.g0.f.a<d.a.n0.x1.h.a, b> {
    public View k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public View p;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.k = view;
        this.l = (TextView) view.findViewById(R.id.title);
        TextView textView = (TextView) view.findViewById(R.id.content);
        this.m = textView;
        textView.setSingleLine();
        this.m.setEllipsize(TextUtils.TruncateAt.END);
        this.n = (TextView) view.findViewById(R.id.time);
        this.o = (TextView) view.findViewById(R.id.live_status);
        this.p = view.findViewById(R.id.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.g0.f.e
    /* renamed from: o */
    public void k(d.a.n0.x1.h.a aVar) {
        super.k(aVar);
        if (aVar == null) {
            return;
        }
        if (this.l != null) {
            if (aVar.k() == 49) {
                if (StringUtils.isNull(aVar.c())) {
                    if (StringUtils.isNull(aVar.o())) {
                        this.l.setText(i(R.string.pb_history_default_user_name));
                    } else {
                        this.l.setText(aVar.o());
                    }
                } else {
                    this.l.setText(aVar.c());
                }
            } else if (aVar.j() != null) {
                if (aVar.t()) {
                    this.l.setText(String.format("%s%s", i(R.string.pb_history_share_prefix), aVar.j()));
                } else {
                    this.l.setText(aVar.j());
                }
            }
        }
        if (this.m != null) {
            if (aVar.k() == 49 && !TextUtils.isEmpty(aVar.o())) {
                this.m.setText(String.format(i(R.string.pb_history_user_name), aVar.o()));
            } else if (aVar.k() == 49) {
                this.m.setText(String.format(i(R.string.pb_history_user_name), i(R.string.pb_history_default_user_name)));
            } else if (aVar.d() != null) {
                this.m.setText(aVar.d());
            }
        }
        if (aVar.k() == 49) {
            this.o.setVisibility(aVar.q() ? 0 : 8);
        } else {
            this.o.setVisibility(8);
        }
        if (this.n != null) {
            String GetPostTimeString = StringHelper.GetPostTimeString(new Date(aVar.m()));
            if (GetPostTimeString == null) {
                GetPostTimeString = "";
            }
            this.n.setText(GetPostTimeString);
        }
    }

    @Override // d.a.n0.e3.t
    @SuppressLint({"ResourceAsColor"})
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setBackgroundResource(this.k, R.drawable.list_item_selector);
        SkinManager.setBackgroundResource(this.p, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0101);
        TBSelector.makeDrawableSelector().cornerRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds6)).gradientLinear(DrawableSelector.LEFT_RIGHT, R.color.CAM_X0308, R.color.CAM_X0301).into(this.o);
        return true;
    }
}
