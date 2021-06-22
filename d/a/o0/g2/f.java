package d.a.o0.g2;

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
    public RoundLinearLayout f58987a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f58988b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58989c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58990d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58991e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f58992f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58993g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58994h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f58995i;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.f58992f = tbPageContext;
        l(tbPageContext, onClickListener);
    }

    public View d() {
        return this.f58990d;
    }

    public View e() {
        return this.f58988b;
    }

    public View f() {
        return this.f58991e;
    }

    public View h() {
        return this.f58995i;
    }

    public View i() {
        return this.f58989c;
    }

    public View k() {
        return this.f58987a;
    }

    public final void l(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.f58987a = roundLinearLayout;
        roundLinearLayout.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
        TextView textView = (TextView) this.f58987a.findViewById(R.id.person_info_more_view_item_friend);
        this.f58988b = textView;
        textView.setOnClickListener(onClickListener);
        TextView textView2 = (TextView) this.f58987a.findViewById(R.id.person_info_more_view_item_report);
        this.f58989c = textView2;
        textView2.setOnClickListener(onClickListener);
        TextView textView3 = (TextView) this.f58987a.findViewById(R.id.person_info_more_view_item_black);
        this.f58990d = textView3;
        textView3.setOnClickListener(onClickListener);
        TextView textView4 = (TextView) this.f58987a.findViewById(R.id.person_info_more_view_item_mute);
        this.f58991e = textView4;
        textView4.setOnClickListener(onClickListener);
        TextView textView5 = (TextView) this.f58987a.findViewById(R.id.person_info_more_view_item_cancel);
        this.f58993g = textView5;
        textView5.setOnClickListener(onClickListener);
        this.f58994h = (TextView) this.f58987a.findViewById(R.id.person_info_more_view_item_username);
        TextView textView6 = (TextView) this.f58987a.findViewById(R.id.person_info_item_remove_fans_view);
        this.f58995i = textView6;
        textView6.setOnClickListener(onClickListener);
    }

    public void m() {
        SkinManager.setBackgroundResource(this.f58987a, R.color.CAM_X0211);
        SkinManager.setViewTextColorSelector(this.f58990d, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f58988b, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f58989c, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f58991e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f58994h, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColorSelector(this.f58995i, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f58993g, R.color.CAM_X0107);
    }

    public void n(int i2) {
        this.f58991e.setVisibility(0);
        if (i2 == 0) {
            this.f58991e.setText(this.f58992f.getResources().getString(R.string.mute));
        } else if (i2 == 1) {
            this.f58991e.setText(this.f58992f.getResources().getString(R.string.un_mute));
        }
    }

    public void o(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.f58988b.setText(R.string.remove_friend);
        } else {
            this.f58988b.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.f58990d.setText(R.string.remove_block_chat);
        } else {
            this.f58990d.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.f58995i.setVisibility(0);
        } else {
            this.f58995i.setVisibility(8);
        }
    }

    public void p(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f58994h.setVisibility(8);
            return;
        }
        this.f58994h.setVisibility(0);
        this.f58994h.setText(String.format(this.f58992f.getResources().getString(R.string.more_info_username), str));
    }
}
