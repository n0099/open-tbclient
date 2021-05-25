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
    public RoundLinearLayout f55173a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f55174b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f55175c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55176d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55177e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f55178f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55179g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f55180h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f55181i;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.f55178f = tbPageContext;
        k(tbPageContext, onClickListener);
    }

    public View d() {
        return this.f55176d;
    }

    public View e() {
        return this.f55174b;
    }

    public View f() {
        return this.f55177e;
    }

    public View g() {
        return this.f55181i;
    }

    public View h() {
        return this.f55175c;
    }

    public View j() {
        return this.f55173a;
    }

    public final void k(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.f55173a = roundLinearLayout;
        roundLinearLayout.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
        TextView textView = (TextView) this.f55173a.findViewById(R.id.person_info_more_view_item_friend);
        this.f55174b = textView;
        textView.setOnClickListener(onClickListener);
        TextView textView2 = (TextView) this.f55173a.findViewById(R.id.person_info_more_view_item_report);
        this.f55175c = textView2;
        textView2.setOnClickListener(onClickListener);
        TextView textView3 = (TextView) this.f55173a.findViewById(R.id.person_info_more_view_item_black);
        this.f55176d = textView3;
        textView3.setOnClickListener(onClickListener);
        TextView textView4 = (TextView) this.f55173a.findViewById(R.id.person_info_more_view_item_mute);
        this.f55177e = textView4;
        textView4.setOnClickListener(onClickListener);
        TextView textView5 = (TextView) this.f55173a.findViewById(R.id.person_info_more_view_item_cancel);
        this.f55179g = textView5;
        textView5.setOnClickListener(onClickListener);
        this.f55180h = (TextView) this.f55173a.findViewById(R.id.person_info_more_view_item_username);
        TextView textView6 = (TextView) this.f55173a.findViewById(R.id.person_info_item_remove_fans_view);
        this.f55181i = textView6;
        textView6.setOnClickListener(onClickListener);
    }

    public void l() {
        SkinManager.setBackgroundResource(this.f55173a, R.color.CAM_X0211);
        SkinManager.setViewTextColorSelector(this.f55176d, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f55174b, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f55175c, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f55177e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f55180h, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColorSelector(this.f55181i, R.color.CAM_X0105);
        SkinManager.setViewTextColorSelector(this.f55179g, R.color.CAM_X0107);
    }

    public void m(int i2) {
        this.f55177e.setVisibility(0);
        if (i2 == 0) {
            this.f55177e.setText(this.f55178f.getResources().getString(R.string.mute));
        } else if (i2 == 1) {
            this.f55177e.setText(this.f55178f.getResources().getString(R.string.un_mute));
        }
    }

    public void n(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.f55174b.setText(R.string.remove_friend);
        } else {
            this.f55174b.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.f55176d.setText(R.string.remove_block_chat);
        } else {
            this.f55176d.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.f55181i.setVisibility(0);
        } else {
            this.f55181i.setVisibility(8);
        }
    }

    public void o(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f55180h.setVisibility(8);
            return;
        }
        this.f55180h.setVisibility(0);
        this.f55180h.setText(String.format(this.f55178f.getResources().getString(R.string.more_info_username), str));
    }
}
