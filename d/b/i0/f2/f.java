package d.b.i0.f2;

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
/* loaded from: classes3.dex */
public class f extends d.b.c.a.d {

    /* renamed from: a  reason: collision with root package name */
    public RoundLinearLayout f55970a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f55971b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f55972c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55973d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55974e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f55975f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55976g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f55977h;
    public TextView i;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.f55975f = tbPageContext;
        l(tbPageContext, onClickListener);
    }

    public View d() {
        return this.f55973d;
    }

    public View e() {
        return this.f55971b;
    }

    public View f() {
        return this.f55974e;
    }

    public View h() {
        return this.i;
    }

    public View i() {
        return this.f55972c;
    }

    public View k() {
        return this.f55970a;
    }

    public final void l(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.f55970a = roundLinearLayout;
        roundLinearLayout.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
        TextView textView = (TextView) this.f55970a.findViewById(R.id.person_info_more_view_item_friend);
        this.f55971b = textView;
        textView.setOnClickListener(onClickListener);
        TextView textView2 = (TextView) this.f55970a.findViewById(R.id.person_info_more_view_item_report);
        this.f55972c = textView2;
        textView2.setOnClickListener(onClickListener);
        TextView textView3 = (TextView) this.f55970a.findViewById(R.id.person_info_more_view_item_black);
        this.f55973d = textView3;
        textView3.setOnClickListener(onClickListener);
        TextView textView4 = (TextView) this.f55970a.findViewById(R.id.person_info_more_view_item_mute);
        this.f55974e = textView4;
        textView4.setOnClickListener(onClickListener);
        TextView textView5 = (TextView) this.f55970a.findViewById(R.id.person_info_more_view_item_cancel);
        this.f55976g = textView5;
        textView5.setOnClickListener(onClickListener);
        this.f55977h = (TextView) this.f55970a.findViewById(R.id.person_info_more_view_item_username);
        TextView textView6 = (TextView) this.f55970a.findViewById(R.id.person_info_item_remove_fans_view);
        this.i = textView6;
        textView6.setOnClickListener(onClickListener);
    }

    public void m() {
        SkinManager.setBackgroundResource(this.f55970a, R.color.CAM_X0211);
        SkinManager.setViewTextColorSelector(this.f55973d, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f55971b, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f55972c, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f55974e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f55977h, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColorSelector(this.i, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f55976g, R.color.CAM_X0107);
    }

    public void n(int i) {
        this.f55974e.setVisibility(0);
        if (i == 0) {
            this.f55974e.setText(this.f55975f.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.f55974e.setText(this.f55975f.getResources().getString(R.string.un_mute));
        }
    }

    public void o(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.f55971b.setText(R.string.remove_friend);
        } else {
            this.f55971b.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.f55973d.setText(R.string.remove_block_chat);
        } else {
            this.f55973d.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
    }

    public void q(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f55977h.setVisibility(8);
            return;
        }
        this.f55977h.setVisibility(0);
        this.f55977h.setText(String.format(this.f55975f.getResources().getString(R.string.more_info_username), str));
    }
}
