package d.a.k0.f2;

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
    public RoundLinearLayout f54985a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f54986b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f54987c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54988d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f54989e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f54990f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54991g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f54992h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f54993i;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.f54990f = tbPageContext;
        k(tbPageContext, onClickListener);
    }

    public View d() {
        return this.f54988d;
    }

    public View e() {
        return this.f54986b;
    }

    public View f() {
        return this.f54989e;
    }

    public View g() {
        return this.f54993i;
    }

    public View h() {
        return this.f54987c;
    }

    public View j() {
        return this.f54985a;
    }

    public final void k(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.f54985a = roundLinearLayout;
        roundLinearLayout.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
        TextView textView = (TextView) this.f54985a.findViewById(R.id.person_info_more_view_item_friend);
        this.f54986b = textView;
        textView.setOnClickListener(onClickListener);
        TextView textView2 = (TextView) this.f54985a.findViewById(R.id.person_info_more_view_item_report);
        this.f54987c = textView2;
        textView2.setOnClickListener(onClickListener);
        TextView textView3 = (TextView) this.f54985a.findViewById(R.id.person_info_more_view_item_black);
        this.f54988d = textView3;
        textView3.setOnClickListener(onClickListener);
        TextView textView4 = (TextView) this.f54985a.findViewById(R.id.person_info_more_view_item_mute);
        this.f54989e = textView4;
        textView4.setOnClickListener(onClickListener);
        TextView textView5 = (TextView) this.f54985a.findViewById(R.id.person_info_more_view_item_cancel);
        this.f54991g = textView5;
        textView5.setOnClickListener(onClickListener);
        this.f54992h = (TextView) this.f54985a.findViewById(R.id.person_info_more_view_item_username);
        TextView textView6 = (TextView) this.f54985a.findViewById(R.id.person_info_item_remove_fans_view);
        this.f54993i = textView6;
        textView6.setOnClickListener(onClickListener);
    }

    public void l() {
        SkinManager.setBackgroundResource(this.f54985a, R.color.CAM_X0211);
        SkinManager.setViewTextColorSelector(this.f54988d, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f54986b, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f54987c, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f54989e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f54992h, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColorSelector(this.f54993i, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f54991g, R.color.CAM_X0107);
    }

    public void m(int i2) {
        this.f54989e.setVisibility(0);
        if (i2 == 0) {
            this.f54989e.setText(this.f54990f.getResources().getString(R.string.mute));
        } else if (i2 == 1) {
            this.f54989e.setText(this.f54990f.getResources().getString(R.string.un_mute));
        }
    }

    public void n(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.f54986b.setText(R.string.remove_friend);
        } else {
            this.f54986b.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.f54988d.setText(R.string.remove_block_chat);
        } else {
            this.f54988d.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.f54993i.setVisibility(0);
        } else {
            this.f54993i.setVisibility(8);
        }
    }

    public void o(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f54992h.setVisibility(8);
            return;
        }
        this.f54992h.setVisibility(0);
        this.f54992h.setText(String.format(this.f54990f.getResources().getString(R.string.more_info_username), str));
    }
}
