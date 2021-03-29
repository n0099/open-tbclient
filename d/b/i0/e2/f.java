package d.b.i0.e2;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f extends d.b.b.a.d {

    /* renamed from: a  reason: collision with root package name */
    public RoundLinearLayout f54529a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f54530b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f54531c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54532d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f54533e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f54534f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54535g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f54536h;
    public TextView i;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.f54534f = tbPageContext;
        l(tbPageContext, onClickListener);
    }

    public View d() {
        return this.f54532d;
    }

    public View e() {
        return this.f54530b;
    }

    public View f() {
        return this.f54533e;
    }

    public View h() {
        return this.i;
    }

    public View i() {
        return this.f54531c;
    }

    public View k() {
        return this.f54529a;
    }

    public final void l(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.f54529a = roundLinearLayout;
        roundLinearLayout.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
        TextView textView = (TextView) this.f54529a.findViewById(R.id.person_info_more_view_item_friend);
        this.f54530b = textView;
        textView.setOnClickListener(onClickListener);
        TextView textView2 = (TextView) this.f54529a.findViewById(R.id.person_info_more_view_item_report);
        this.f54531c = textView2;
        textView2.setOnClickListener(onClickListener);
        TextView textView3 = (TextView) this.f54529a.findViewById(R.id.person_info_more_view_item_black);
        this.f54532d = textView3;
        textView3.setOnClickListener(onClickListener);
        TextView textView4 = (TextView) this.f54529a.findViewById(R.id.person_info_more_view_item_mute);
        this.f54533e = textView4;
        textView4.setOnClickListener(onClickListener);
        TextView textView5 = (TextView) this.f54529a.findViewById(R.id.person_info_more_view_item_cancel);
        this.f54535g = textView5;
        textView5.setOnClickListener(onClickListener);
        this.f54536h = (TextView) this.f54529a.findViewById(R.id.person_info_more_view_item_username);
        TextView textView6 = (TextView) this.f54529a.findViewById(R.id.person_info_item_remove_fans_view);
        this.i = textView6;
        textView6.setOnClickListener(onClickListener);
    }

    public void m() {
        SkinManager.setBackgroundResource(this.f54529a, R.color.CAM_X0211);
        SkinManager.setViewTextColorSelector(this.f54532d, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f54530b, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f54531c, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f54533e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f54536h, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColorSelector(this.i, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f54535g, R.color.CAM_X0107);
    }

    public void n(int i) {
        this.f54533e.setVisibility(0);
        if (i == 0) {
            this.f54533e.setText(this.f54534f.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.f54533e.setText(this.f54534f.getResources().getString(R.string.un_mute));
        }
    }

    public void o(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.f54530b.setText(R.string.remove_friend);
        } else {
            this.f54530b.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.f54532d.setText(R.string.remove_block_chat);
        } else {
            this.f54532d.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
    }

    public void q(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f54536h.setVisibility(8);
            return;
        }
        this.f54536h.setVisibility(0);
        this.f54536h.setText(String.format(this.f54534f.getResources().getString(R.string.more_info_username), str));
    }
}
