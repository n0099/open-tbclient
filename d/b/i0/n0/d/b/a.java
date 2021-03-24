package d.b.i0.n0.d.b;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivity;
import d.b.b.a.d;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import java.util.List;
import tbclient.GetLevelInfo.DataRes;
import tbclient.LevelInfo;
/* loaded from: classes4.dex */
public class a extends d<TbTitleActivity> {

    /* renamed from: a  reason: collision with root package name */
    public TbTitleActivity f57073a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f57074b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f57075c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f57076d;

    /* renamed from: e  reason: collision with root package name */
    public ScrollView f57077e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f57078f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57079g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f57080h;
    public TextView i;
    public TextView j;
    public LinearLayout k;
    public View l;
    public View.OnClickListener m;
    public List<LevelInfo> n;
    public DataRes o;
    public b p;

    /* renamed from: d.b.i0.n0.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1354a implements View.OnClickListener {
        public View$OnClickListenerC1354a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.f57073a.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public View.OnClickListener f57082e;

        public b(a aVar, View.OnClickListener onClickListener) {
            this.f57082e = onClickListener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.f57082e.onClick(view);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SkinManager.getColor(R.color.CAM_X0302));
            textPaint.setUnderlineText(false);
        }
    }

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.p = new b(this, new View$OnClickListenerC1354a());
        this.f57073a = tbTitleActivity;
        this.m = onClickListener;
        initUI();
    }

    public void e(DataRes dataRes) {
        LinearLayout linearLayout;
        this.o = dataRes;
        if (dataRes == null) {
            return;
        }
        if (dataRes.is_like.intValue() == 1 && (linearLayout = this.k) != null) {
            linearLayout.setVisibility(8);
        }
        if (this.f57079g != null) {
            if (StringUtils.isNull(this.o.level_name, true)) {
                this.f57079g.setText(this.o.level_name);
            } else {
                this.f57079g.setVisibility(8);
            }
        }
        if (this.f57080h != null) {
            if (this.o.user_level.intValue() > 0 && this.o.user_level.intValue() <= 18) {
                SkinManager.setImageResource(this.f57080h, BitmapHelper.getGradeResourceIdNew(this.o.user_level.intValue()));
            } else {
                this.f57080h.setVisibility(8);
            }
        }
    }

    public void f(List<LevelInfo> list) {
        this.n = list;
        if (this.f57078f == null || list == null || list.size() == 0) {
            return;
        }
        this.f57078f.removeAllViews();
        for (int i = 1; i <= list.size(); i++) {
            LevelInfo levelInfo = list.get(i - 1);
            View inflate = LayoutInflater.from(this.f57073a.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.table_item_background);
            TextView textView = (TextView) inflate.findViewById(R.id.table_item_level_name);
            TextView textView2 = (TextView) inflate.findViewById(R.id.table_item_need_experienment);
            View findViewById = inflate.findViewById(R.id.tbtile_item_horizontal_line);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.table_item_level_img);
            if (i % 2 != 0) {
                SkinManager.setBackgroundResource(linearLayout, R.color.CAM_X0205);
            }
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0204);
            SkinManager.setImageResource(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
            textView.setText(levelInfo.name);
            if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                textView2.setText(levelInfo.score + "");
            } else if (levelInfo.score.intValue() <= 0) {
                textView2.setText("0");
            } else {
                textView2.setText("3000000");
            }
            this.f57078f.addView(inflate);
        }
    }

    public void h() {
        this.f57077e.setVisibility(0);
        this.f57073a.hideLoadingView(this.f57074b);
    }

    public void i() {
        this.f57077e.setVisibility(0);
        this.f57073a.hideNetRefreshView(this.f57074b);
    }

    public final void initUI() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f57073a.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.f57074b = relativeLayout;
        this.f57073a.setContentView(relativeLayout);
        this.l = this.f57074b.findViewById(R.id.top_view);
        if (!j.A()) {
            this.l.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.g(this.f57073a.getActivity(), R.dimen.ds170);
        } else {
            this.l.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.g(this.f57073a.getActivity(), R.dimen.ds88);
        }
        NavigationBar navigationBar = (NavigationBar) this.f57074b.findViewById(R.id.view_navigation_bar);
        this.f57076d = navigationBar;
        navigationBar.setCenterTextTitle(this.f57073a.getString(R.string.tbtitle_title));
        this.f57076d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57076d.showBottomLine();
        this.f57077e = (ScrollView) this.f57074b.findViewById(R.id.tbtitle_scroll_view);
        this.k = (LinearLayout) this.f57074b.findViewById(R.id.first_line_layout);
        this.j = (TextView) this.f57074b.findViewById(R.id.tbtile_like_btn);
        this.f57078f = (LinearLayout) this.f57074b.findViewById(R.id.table_canvas);
        this.f57079g = (TextView) this.f57074b.findViewById(R.id.user_level_name);
        this.f57080h = (ImageView) this.f57074b.findViewById(R.id.header_level_img);
        this.i = (TextView) this.f57074b.findViewById(R.id.tbtitle_tip_detail2);
        this.f57075c = (NoNetworkView) this.f57074b.findViewById(R.id.view_no_network);
        k();
        n();
    }

    public final void k() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.p, indexOf, length + indexOf, 33);
        this.i.setText(spannableString);
        this.i.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void l(int i) {
        NavigationBar navigationBar = this.f57076d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f57073a.getPageContext(), i);
        }
        NoNetworkView noNetworkView = this.f57075c;
        if (noNetworkView != null) {
            noNetworkView.c(this.f57073a.getPageContext(), i);
        }
        f(this.n);
        e(this.o);
        this.f57073a.getLayoutMode().k(i == 1);
        this.f57073a.getLayoutMode().j(this.f57074b);
    }

    public void m(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.g(this.f57073a.getActivity(), R.dimen.ds170);
            this.l.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.l.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.g(this.f57073a.getActivity(), R.dimen.ds88);
        this.l.setLayoutParams(layoutParams2);
    }

    public final void n() {
        this.j.setOnClickListener(this.m);
        this.i.setOnClickListener(this.m);
    }

    public void o(NoNetworkView.b bVar) {
        if (bVar != null) {
            this.f57075c.a(bVar);
        }
    }

    public void q() {
        this.f57077e.setVisibility(8);
        this.f57073a.showLoadingView(this.f57074b, true);
    }

    public void r(String str) {
        this.f57077e.setVisibility(8);
        this.f57073a.showNetRefreshView(this.f57074b, str, true);
        this.f57073a.setNetRefreshViewTopMargin(400);
    }
}
