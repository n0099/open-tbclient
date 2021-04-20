package d.b.i0.f1.b;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.switchs.MessageChooseFriendSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.ChatAggregationFragment;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class h extends d.b.c.a.d implements NoNetworkView.b {

    /* renamed from: e  reason: collision with root package name */
    public MessageCenterFragment f55856e;

    /* renamed from: f  reason: collision with root package name */
    public TbTabLayout f55857f;

    /* renamed from: g  reason: collision with root package name */
    public BdBaseViewPager f55858g;

    /* renamed from: h  reason: collision with root package name */
    public MessageFragmentPagerAdapter f55859h;
    public List<MessageFragmentPagerAdapter.a> i;
    public View j;
    public ChatAggregationFragment k;
    public ImageView l;
    public NavigationBar m;
    public NoNetworkView n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.f55856e != null) {
                h.this.f55856e.G0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.f55856e != null) {
                h.this.f55856e.H0();
            }
        }
    }

    public h(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        this.f55856e = messageCenterFragment;
    }

    public static String m(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void b(boolean z) {
        Fragment fragment;
        List<MessageFragmentPagerAdapter.a> list = this.i;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.i.size(); i++) {
            MessageFragmentPagerAdapter.a aVar = this.i.get(i);
            if (aVar != null && (fragment = aVar.f18000a) != null && (fragment instanceof NoNetworkView.b)) {
                ((NoNetworkView.b) fragment).b(z);
            }
        }
    }

    public void e(TbTabLayout.c cVar) {
        TbTabLayout tbTabLayout = this.f55857f;
        if (tbTabLayout == null || cVar == null) {
            return;
        }
        tbTabLayout.c(cVar);
    }

    public TbTabLayout.f f() {
        TbTabLayout tbTabLayout = this.f55857f;
        if (tbTabLayout == null || tbTabLayout.getTabCount() <= 0) {
            return null;
        }
        TbTabLayout tbTabLayout2 = this.f55857f;
        return tbTabLayout2.w(tbTabLayout2.getSelectedTabPosition());
    }

    public TbTabLayout.f g(int i) {
        int tabCount;
        TbTabLayout tbTabLayout = this.f55857f;
        if (tbTabLayout != null && (tabCount = tbTabLayout.getTabCount()) > 0) {
            for (int i2 = 0; i2 < tabCount; i2++) {
                TbTabLayout.f w = this.f55857f.w(i2);
                if (w != null && w.d() != -1 && w.d() == i) {
                    return w;
                }
            }
        }
        return null;
    }

    public final void h(Bundle bundle) {
        NavigationBar navigationBar = (NavigationBar) this.j.findViewById(R.id.navigation_bar);
        this.m = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        if (addSystemImageButton != null) {
            if (this.f55856e.getActivity() instanceof MessageCenterActivity) {
                addSystemImageButton.setVisibility(0);
            } else {
                addSystemImageButton.setVisibility(4);
            }
        }
        this.l = new ImageView(this.f55856e.getContext());
        int g2 = d.b.c.e.p.l.g(this.f55856e.getContext(), R.dimen.ds88);
        this.l.setLayoutParams(new ViewGroup.LayoutParams(g2, g2));
        this.l.setScaleType(ImageView.ScaleType.CENTER);
        this.m.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.l, new b());
        if (this.l.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, d.b.c.e.p.l.g(this.f55856e.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
            this.l.setLayoutParams(marginLayoutParams);
        }
        if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(4);
        }
        TbTabLayout tbTabLayout = this.f55857f;
        if (tbTabLayout != null) {
            this.m.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, tbTabLayout, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.f55857f.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(17);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 17;
                viewGroup.setLayoutParams(layoutParams);
            }
            TbTabLayout tbTabLayout2 = this.f55857f;
            tbTabLayout2.setPadding(tbTabLayout2.getPaddingLeft(), this.f55857f.getPaddingTop(), this.f55857f.getPaddingRight(), this.f55857f.getPaddingBottom() + d.b.c.e.p.l.g(this.f55856e.getContext(), R.dimen.ds1));
        }
    }

    public final void i(Bundle bundle) {
        TbTabLayout tbTabLayout = (TbTabLayout) LayoutInflater.from(this.f55856e.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
        this.f55857f = tbTabLayout;
        tbTabLayout.setupWithViewPager(this.f55858g);
        int tabCount = this.f55857f.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                this.f55857f.w(i).q(1);
            }
        }
    }

    public void k(View view, Bundle bundle) {
        if (view == null) {
            return;
        }
        this.j = view;
        l(bundle);
        i(bundle);
        h(bundle);
        NoNetworkView noNetworkView = (NoNetworkView) this.j.findViewById(R.id.view_no_network);
        this.n = noNetworkView;
        noNetworkView.a(this);
    }

    public final void l(Bundle bundle) {
        this.f55858g = (BdBaseViewPager) this.j.findViewById(R.id.message_viewpager);
        MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
        ChatAggregationFragment chatAggregationFragment = new ChatAggregationFragment();
        this.k = chatAggregationFragment;
        aVar.f18000a = chatAggregationFragment;
        aVar.f18001b = this.f55856e.getResources().getString(R.string.message_center_message_tab);
        ArrayList arrayList = new ArrayList();
        this.i = arrayList;
        arrayList.add(aVar);
        MessageFragmentPagerAdapter messageFragmentPagerAdapter = new MessageFragmentPagerAdapter(this.f55856e.getActivity().getSupportFragmentManager(), this.i);
        this.f55859h = messageFragmentPagerAdapter;
        this.f55858g.setAdapter(messageFragmentPagerAdapter);
        this.f55858g.setOffscreenPageLimit(this.i.size());
        this.f55859h.notifyDataSetChanged();
    }

    public void n(int i, int i2, Intent intent) {
        BdBaseViewPager bdBaseViewPager;
        Fragment fragment;
        List<MessageFragmentPagerAdapter.a> list = this.i;
        if (list == null || list.size() <= 0 || (bdBaseViewPager = this.f55858g) == null) {
            return;
        }
        MessageFragmentPagerAdapter.a aVar = this.i.get(bdBaseViewPager.getCurrentItem());
        if (aVar == null || (fragment = aVar.f18000a) == null) {
            return;
        }
        fragment.onActivityResult(i, i2, intent);
    }

    public void o() {
        MessageCenterFragment messageCenterFragment = this.f55856e;
        if (messageCenterFragment != null && this.i != null && this.f55858g != null && this.f55859h != null) {
            FragmentManager supportFragmentManager = messageCenterFragment.getActivity().getSupportFragmentManager();
            if (supportFragmentManager.isDestroyed()) {
                return;
            }
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            for (int i = 0; i < this.i.size(); i++) {
                Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(m(this.f55858g.getId(), this.f55859h.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
        }
        NoNetworkView noNetworkView = this.n;
        if (noNetworkView != null) {
            noNetworkView.d(this);
        }
    }

    public void onChangeSkinType(int i) {
        Fragment fragment;
        NavigationBar navigationBar = this.m;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(getPageContext(), i);
            SkinManager.setBackgroundColor(this.m.getBarBgView(), R.color.CAM_X0207, i);
        }
        NoNetworkView noNetworkView = this.n;
        if (noNetworkView != null) {
            noNetworkView.c(getPageContext(), i);
        }
        List<MessageFragmentPagerAdapter.a> list = this.i;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                MessageFragmentPagerAdapter.a aVar = this.i.get(i2);
                if (aVar != null && (fragment = aVar.f18000a) != null && (fragment instanceof BaseFragment)) {
                    ((BaseFragment) fragment).onChangeSkinType(i);
                }
            }
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.ic_icon_pure_chat_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        TbTabLayout tbTabLayout = this.f55857f;
        if (tbTabLayout != null) {
            tbTabLayout.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
            this.f55857f.setSelectedTabIndicatorHeight(0);
            this.f55857f.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
        }
    }

    public void q() {
        ChatAggregationFragment chatAggregationFragment = this.k;
        if (chatAggregationFragment != null) {
            chatAggregationFragment.w();
        }
    }

    public void r(TbTabLayout.c cVar) {
        TbTabLayout tbTabLayout = this.f55857f;
        if (tbTabLayout == null || cVar == null) {
            return;
        }
        tbTabLayout.C(cVar);
    }

    public void s(int i) {
        TbTabLayout.f g2 = g(i);
        if (g2 != null) {
            g2.l();
        }
    }

    public void u(boolean z) {
        BdBaseViewPager bdBaseViewPager;
        Fragment fragment;
        MessageFragmentPagerAdapter messageFragmentPagerAdapter = this.f55859h;
        if (messageFragmentPagerAdapter != null) {
            messageFragmentPagerAdapter.c(z);
        }
        List<MessageFragmentPagerAdapter.a> list = this.i;
        if (list == null || list.size() <= 0 || (bdBaseViewPager = this.f55858g) == null) {
            return;
        }
        MessageFragmentPagerAdapter.a aVar = this.i.get(bdBaseViewPager.getCurrentItem());
        if (aVar == null || (fragment = aVar.f18000a) == null || !(fragment instanceof BaseFragment)) {
            return;
        }
        ((BaseFragment) fragment).setPrimary(z);
    }
}
