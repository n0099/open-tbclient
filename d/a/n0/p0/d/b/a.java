package d.a.n0.p0.d.b;

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
import d.a.c.a.d;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import java.util.List;
import tbclient.GetLevelInfo.DataRes;
import tbclient.LevelInfo;
/* loaded from: classes4.dex */
public class a extends d<TbTitleActivity> {

    /* renamed from: a  reason: collision with root package name */
    public TbTitleActivity f58038a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f58039b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f58040c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f58041d;

    /* renamed from: e  reason: collision with root package name */
    public ScrollView f58042e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f58043f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58044g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f58045h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f58046i;
    public TextView j;
    public LinearLayout k;
    public View l;
    public View.OnClickListener m;
    public List<LevelInfo> n;
    public DataRes o;
    public b p;

    /* renamed from: d.a.n0.p0.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1463a implements View.OnClickListener {
        public View$OnClickListenerC1463a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.f58038a.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public View.OnClickListener f58048e;

        public b(a aVar, View.OnClickListener onClickListener) {
            this.f58048e = onClickListener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.f58048e.onClick(view);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SkinManager.getColor(R.color.CAM_X0302));
            textPaint.setUnderlineText(false);
        }
    }

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.p = new b(this, new View$OnClickListenerC1463a());
        this.f58038a = tbTitleActivity;
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
        if (this.f58044g != null) {
            if (StringUtils.isNull(this.o.level_name, true)) {
                this.f58044g.setText(this.o.level_name);
            } else {
                this.f58044g.setVisibility(8);
            }
        }
        if (this.f58045h != null) {
            if (this.o.user_level.intValue() > 0 && this.o.user_level.intValue() <= 18) {
                SkinManager.setImageResource(this.f58045h, BitmapHelper.getGradeResourceIdNew(this.o.user_level.intValue()));
            } else {
                this.f58045h.setVisibility(8);
            }
        }
    }

    public void f(List<LevelInfo> list) {
        this.n = list;
        if (this.f58043f == null || list == null || list.size() == 0) {
            return;
        }
        this.f58043f.removeAllViews();
        for (int i2 = 1; i2 <= list.size(); i2++) {
            LevelInfo levelInfo = list.get(i2 - 1);
            View inflate = LayoutInflater.from(this.f58038a.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.table_item_background);
            TextView textView = (TextView) inflate.findViewById(R.id.table_item_level_name);
            TextView textView2 = (TextView) inflate.findViewById(R.id.table_item_need_experienment);
            View findViewById = inflate.findViewById(R.id.tbtile_item_horizontal_line);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.table_item_level_img);
            if (i2 % 2 != 0) {
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
            this.f58043f.addView(inflate);
        }
    }

    public void g() {
        this.f58042e.setVisibility(0);
        this.f58038a.hideLoadingView(this.f58039b);
    }

    public void h() {
        this.f58042e.setVisibility(0);
        this.f58038a.hideNetRefreshView(this.f58039b);
    }

    public final void initUI() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f58038a.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.f58039b = relativeLayout;
        this.f58038a.setContentView(relativeLayout);
        this.l = this.f58039b.findViewById(R.id.top_view);
        if (!j.A()) {
            this.l.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.g(this.f58038a.getActivity(), R.dimen.ds170);
        } else {
            this.l.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.g(this.f58038a.getActivity(), R.dimen.ds88);
        }
        NavigationBar navigationBar = (NavigationBar) this.f58039b.findViewById(R.id.view_navigation_bar);
        this.f58041d = navigationBar;
        navigationBar.setCenterTextTitle(this.f58038a.getString(R.string.tbtitle_title));
        this.f58041d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58041d.showBottomLine();
        this.f58042e = (ScrollView) this.f58039b.findViewById(R.id.tbtitle_scroll_view);
        this.k = (LinearLayout) this.f58039b.findViewById(R.id.first_line_layout);
        this.j = (TextView) this.f58039b.findViewById(R.id.tbtile_like_btn);
        this.f58043f = (LinearLayout) this.f58039b.findViewById(R.id.table_canvas);
        this.f58044g = (TextView) this.f58039b.findViewById(R.id.user_level_name);
        this.f58045h = (ImageView) this.f58039b.findViewById(R.id.header_level_img);
        this.f58046i = (TextView) this.f58039b.findViewById(R.id.tbtitle_tip_detail2);
        this.f58040c = (NoNetworkView) this.f58039b.findViewById(R.id.view_no_network);
        j();
        m();
    }

    public final void j() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.p, indexOf, length + indexOf, 33);
        this.f58046i.setText(spannableString);
        this.f58046i.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void k(int i2) {
        NavigationBar navigationBar = this.f58041d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f58038a.getPageContext(), i2);
        }
        NoNetworkView noNetworkView = this.f58040c;
        if (noNetworkView != null) {
            noNetworkView.c(this.f58038a.getPageContext(), i2);
        }
        f(this.n);
        e(this.o);
        this.f58038a.getLayoutMode().k(i2 == 1);
        this.f58038a.getLayoutMode().j(this.f58039b);
    }

    public void l(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.g(this.f58038a.getActivity(), R.dimen.ds170);
            this.l.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.l.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.g(this.f58038a.getActivity(), R.dimen.ds88);
        this.l.setLayoutParams(layoutParams2);
    }

    public final void m() {
        this.j.setOnClickListener(this.m);
        this.f58046i.setOnClickListener(this.m);
    }

    public void n(NoNetworkView.b bVar) {
        if (bVar != null) {
            this.f58040c.a(bVar);
        }
    }

    public void o() {
        this.f58042e.setVisibility(8);
        this.f58038a.showLoadingView(this.f58039b, true);
    }

    public void p(String str) {
        this.f58042e.setVisibility(8);
        this.f58038a.showNetRefreshView(this.f58039b, str, true);
        this.f58038a.setNetRefreshViewTopMargin(400);
    }
}
