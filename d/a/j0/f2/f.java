package d.a.j0.f2;

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
/* loaded from: classes4.dex */
public class f extends d.a.c.a.d {

    /* renamed from: a  reason: collision with root package name */
    public RoundLinearLayout f54278a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f54279b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f54280c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54281d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f54282e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f54283f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54284g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f54285h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f54286i;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.f54283f = tbPageContext;
        k(tbPageContext, onClickListener);
    }

    public View d() {
        return this.f54281d;
    }

    public View e() {
        return this.f54279b;
    }

    public View f() {
        return this.f54282e;
    }

    public View g() {
        return this.f54286i;
    }

    public View h() {
        return this.f54280c;
    }

    public View j() {
        return this.f54278a;
    }

    public final void k(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.f54278a = roundLinearLayout;
        roundLinearLayout.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
        TextView textView = (TextView) this.f54278a.findViewById(R.id.person_info_more_view_item_friend);
        this.f54279b = textView;
        textView.setOnClickListener(onClickListener);
        TextView textView2 = (TextView) this.f54278a.findViewById(R.id.person_info_more_view_item_report);
        this.f54280c = textView2;
        textView2.setOnClickListener(onClickListener);
        TextView textView3 = (TextView) this.f54278a.findViewById(R.id.person_info_more_view_item_black);
        this.f54281d = textView3;
        textView3.setOnClickListener(onClickListener);
        TextView textView4 = (TextView) this.f54278a.findViewById(R.id.person_info_more_view_item_mute);
        this.f54282e = textView4;
        textView4.setOnClickListener(onClickListener);
        TextView textView5 = (TextView) this.f54278a.findViewById(R.id.person_info_more_view_item_cancel);
        this.f54284g = textView5;
        textView5.setOnClickListener(onClickListener);
        this.f54285h = (TextView) this.f54278a.findViewById(R.id.person_info_more_view_item_username);
        TextView textView6 = (TextView) this.f54278a.findViewById(R.id.person_info_item_remove_fans_view);
        this.f54286i = textView6;
        textView6.setOnClickListener(onClickListener);
    }

    public void l() {
        SkinManager.setBackgroundResource(this.f54278a, R.color.CAM_X0211);
        SkinManager.setViewTextColorSelector(this.f54281d, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f54279b, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f54280c, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f54282e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f54285h, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColorSelector(this.f54286i, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f54284g, R.color.CAM_X0107);
    }

    public void m(int i2) {
        this.f54282e.setVisibility(0);
        if (i2 == 0) {
            this.f54282e.setText(this.f54283f.getResources().getString(R.string.mute));
        } else if (i2 == 1) {
            this.f54282e.setText(this.f54283f.getResources().getString(R.string.un_mute));
        }
    }

    public void n(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.f54279b.setText(R.string.remove_friend);
        } else {
            this.f54279b.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.f54281d.setText(R.string.remove_block_chat);
        } else {
            this.f54281d.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.f54286i.setVisibility(0);
        } else {
            this.f54286i.setVisibility(8);
        }
    }

    public void o(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f54285h.setVisibility(8);
            return;
        }
        this.f54285h.setVisibility(0);
        this.f54285h.setText(String.format(this.f54283f.getResources().getString(R.string.more_info_username), str));
    }
}
