package d.b.j0.f2;

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
    public RoundLinearLayout f56391a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f56392b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56393c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56394d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56395e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f56396f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56397g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56398h;
    public TextView i;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.f56396f = tbPageContext;
        l(tbPageContext, onClickListener);
    }

    public View d() {
        return this.f56394d;
    }

    public View e() {
        return this.f56392b;
    }

    public View f() {
        return this.f56395e;
    }

    public View h() {
        return this.i;
    }

    public View i() {
        return this.f56393c;
    }

    public View k() {
        return this.f56391a;
    }

    public final void l(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.f56391a = roundLinearLayout;
        roundLinearLayout.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
        TextView textView = (TextView) this.f56391a.findViewById(R.id.person_info_more_view_item_friend);
        this.f56392b = textView;
        textView.setOnClickListener(onClickListener);
        TextView textView2 = (TextView) this.f56391a.findViewById(R.id.person_info_more_view_item_report);
        this.f56393c = textView2;
        textView2.setOnClickListener(onClickListener);
        TextView textView3 = (TextView) this.f56391a.findViewById(R.id.person_info_more_view_item_black);
        this.f56394d = textView3;
        textView3.setOnClickListener(onClickListener);
        TextView textView4 = (TextView) this.f56391a.findViewById(R.id.person_info_more_view_item_mute);
        this.f56395e = textView4;
        textView4.setOnClickListener(onClickListener);
        TextView textView5 = (TextView) this.f56391a.findViewById(R.id.person_info_more_view_item_cancel);
        this.f56397g = textView5;
        textView5.setOnClickListener(onClickListener);
        this.f56398h = (TextView) this.f56391a.findViewById(R.id.person_info_more_view_item_username);
        TextView textView6 = (TextView) this.f56391a.findViewById(R.id.person_info_item_remove_fans_view);
        this.i = textView6;
        textView6.setOnClickListener(onClickListener);
    }

    public void m() {
        SkinManager.setBackgroundResource(this.f56391a, R.color.CAM_X0211);
        SkinManager.setViewTextColorSelector(this.f56394d, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f56392b, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f56393c, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f56395e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f56398h, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColorSelector(this.i, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f56397g, R.color.CAM_X0107);
    }

    public void n(int i) {
        this.f56395e.setVisibility(0);
        if (i == 0) {
            this.f56395e.setText(this.f56396f.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.f56395e.setText(this.f56396f.getResources().getString(R.string.un_mute));
        }
    }

    public void o(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.f56392b.setText(R.string.remove_friend);
        } else {
            this.f56392b.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.f56394d.setText(R.string.remove_block_chat);
        } else {
            this.f56394d.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
    }

    public void q(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f56398h.setVisibility(8);
            return;
        }
        this.f56398h.setVisibility(0);
        this.f56398h.setText(String.format(this.f56396f.getResources().getString(R.string.more_info_username), str));
    }
}
