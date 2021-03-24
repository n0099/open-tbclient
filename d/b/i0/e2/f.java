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
    public RoundLinearLayout f54528a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f54529b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f54530c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54531d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f54532e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f54533f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54534g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f54535h;
    public TextView i;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.f54533f = tbPageContext;
        l(tbPageContext, onClickListener);
    }

    public View d() {
        return this.f54531d;
    }

    public View e() {
        return this.f54529b;
    }

    public View f() {
        return this.f54532e;
    }

    public View h() {
        return this.i;
    }

    public View i() {
        return this.f54530c;
    }

    public View k() {
        return this.f54528a;
    }

    public final void l(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.f54528a = roundLinearLayout;
        roundLinearLayout.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
        TextView textView = (TextView) this.f54528a.findViewById(R.id.person_info_more_view_item_friend);
        this.f54529b = textView;
        textView.setOnClickListener(onClickListener);
        TextView textView2 = (TextView) this.f54528a.findViewById(R.id.person_info_more_view_item_report);
        this.f54530c = textView2;
        textView2.setOnClickListener(onClickListener);
        TextView textView3 = (TextView) this.f54528a.findViewById(R.id.person_info_more_view_item_black);
        this.f54531d = textView3;
        textView3.setOnClickListener(onClickListener);
        TextView textView4 = (TextView) this.f54528a.findViewById(R.id.person_info_more_view_item_mute);
        this.f54532e = textView4;
        textView4.setOnClickListener(onClickListener);
        TextView textView5 = (TextView) this.f54528a.findViewById(R.id.person_info_more_view_item_cancel);
        this.f54534g = textView5;
        textView5.setOnClickListener(onClickListener);
        this.f54535h = (TextView) this.f54528a.findViewById(R.id.person_info_more_view_item_username);
        TextView textView6 = (TextView) this.f54528a.findViewById(R.id.person_info_item_remove_fans_view);
        this.i = textView6;
        textView6.setOnClickListener(onClickListener);
    }

    public void m() {
        SkinManager.setBackgroundResource(this.f54528a, R.color.CAM_X0211);
        SkinManager.setViewTextColorSelector(this.f54531d, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f54529b, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f54530c, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f54532e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f54535h, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColorSelector(this.i, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f54534g, R.color.CAM_X0107);
    }

    public void n(int i) {
        this.f54532e.setVisibility(0);
        if (i == 0) {
            this.f54532e.setText(this.f54533f.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.f54532e.setText(this.f54533f.getResources().getString(R.string.un_mute));
        }
    }

    public void o(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.f54529b.setText(R.string.remove_friend);
        } else {
            this.f54529b.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.f54531d.setText(R.string.remove_block_chat);
        } else {
            this.f54531d.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
    }

    public void q(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f54535h.setVisibility(8);
            return;
        }
        this.f54535h.setVisibility(0);
        this.f54535h.setText(String.format(this.f54533f.getResources().getString(R.string.more_info_username), str));
    }
}
