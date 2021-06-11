package d.a.n0.g2;

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
public class f extends d.a.c.a.d {

    /* renamed from: a  reason: collision with root package name */
    public RoundLinearLayout f58862a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f58863b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58864c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58865d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58866e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f58867f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58868g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58869h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f58870i;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.f58867f = tbPageContext;
        l(tbPageContext, onClickListener);
    }

    public View d() {
        return this.f58865d;
    }

    public View e() {
        return this.f58863b;
    }

    public View f() {
        return this.f58866e;
    }

    public View h() {
        return this.f58870i;
    }

    public View i() {
        return this.f58864c;
    }

    public View k() {
        return this.f58862a;
    }

    public final void l(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.f58862a = roundLinearLayout;
        roundLinearLayout.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
        TextView textView = (TextView) this.f58862a.findViewById(R.id.person_info_more_view_item_friend);
        this.f58863b = textView;
        textView.setOnClickListener(onClickListener);
        TextView textView2 = (TextView) this.f58862a.findViewById(R.id.person_info_more_view_item_report);
        this.f58864c = textView2;
        textView2.setOnClickListener(onClickListener);
        TextView textView3 = (TextView) this.f58862a.findViewById(R.id.person_info_more_view_item_black);
        this.f58865d = textView3;
        textView3.setOnClickListener(onClickListener);
        TextView textView4 = (TextView) this.f58862a.findViewById(R.id.person_info_more_view_item_mute);
        this.f58866e = textView4;
        textView4.setOnClickListener(onClickListener);
        TextView textView5 = (TextView) this.f58862a.findViewById(R.id.person_info_more_view_item_cancel);
        this.f58868g = textView5;
        textView5.setOnClickListener(onClickListener);
        this.f58869h = (TextView) this.f58862a.findViewById(R.id.person_info_more_view_item_username);
        TextView textView6 = (TextView) this.f58862a.findViewById(R.id.person_info_item_remove_fans_view);
        this.f58870i = textView6;
        textView6.setOnClickListener(onClickListener);
    }

    public void m() {
        SkinManager.setBackgroundResource(this.f58862a, R.color.CAM_X0211);
        SkinManager.setViewTextColorSelector(this.f58865d, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f58863b, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f58864c, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f58866e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f58869h, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColorSelector(this.f58870i, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f58868g, R.color.CAM_X0107);
    }

    public void n(int i2) {
        this.f58866e.setVisibility(0);
        if (i2 == 0) {
            this.f58866e.setText(this.f58867f.getResources().getString(R.string.mute));
        } else if (i2 == 1) {
            this.f58866e.setText(this.f58867f.getResources().getString(R.string.un_mute));
        }
    }

    public void o(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.f58863b.setText(R.string.remove_friend);
        } else {
            this.f58863b.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.f58865d.setText(R.string.remove_block_chat);
        } else {
            this.f58865d.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.f58870i.setVisibility(0);
        } else {
            this.f58870i.setVisibility(8);
        }
    }

    public void p(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f58869h.setVisibility(8);
            return;
        }
        this.f58869h.setVisibility(0);
        this.f58869h.setText(String.format(this.f58867f.getResources().getString(R.string.more_info_username), str));
    }
}
