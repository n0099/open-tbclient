package d.a.k0.z1.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.fragment.InterestSelectionFragment;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import d.a.k0.z1.c.b;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener, InterestSelectionFragment.a {

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f63692e;

    /* renamed from: f  reason: collision with root package name */
    public int f63693f;

    /* renamed from: g  reason: collision with root package name */
    public View f63694g;

    /* renamed from: h  reason: collision with root package name */
    public View f63695h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f63696i;
    public NavigationBar j;
    public InterestedForumFragment k;
    public InterestSelectionFragment l;

    public a(BaseFragmentActivity baseFragmentActivity, int i2) {
        this.f63692e = baseFragmentActivity;
        this.f63693f = i2;
        e();
        f();
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void a(List<b> list) {
        InterestedForumFragment D0 = InterestedForumFragment.D0(this.f63693f);
        this.k = D0;
        D0.J0(list);
        b().beginTransaction().add(R.id.content_container, this.k).addToBackStack(null).commitAllowingStateLoss();
        d.a.k0.z1.d.a.a(b().getFragments().size() == 1 ? 1 : 2, 1, this.f63693f);
    }

    public final FragmentManager b() {
        return this.f63692e.getSupportFragmentManager();
    }

    public View c() {
        return this.f63694g;
    }

    public final void d() {
        StatisticItem statisticItem = new StatisticItem("c13682");
        statisticItem.param("obj_type", 1);
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.f63692e).createNormalCfg(0)));
    }

    public final void e() {
        View inflate = LayoutInflater.from(this.f63692e).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.f63694g = inflate;
        NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
        this.j = navigationBar;
        TextView addTextButton = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f63692e.getString(R.string.skip));
        this.f63696i = addTextButton;
        addTextButton.setId(R.id.btn_skip);
        SkinManager.setViewTextColor(this.f63696i, R.color.CAM_X0107);
        this.f63695h = this.j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.l = InterestSelectionFragment.D0(this.f63693f);
        b().beginTransaction().add(R.id.content_container, this.l).commitAllowingStateLoss();
        TiebaStatic.log(new StatisticItem("c13681"));
    }

    public final void f() {
        this.f63696i.setOnClickListener(this);
        this.f63695h.setOnClickListener(this);
        this.l.G0(this);
    }

    public void g() {
        if (b().getFragments().size() == 1) {
            d.a.k0.z1.d.a.b(1, this.f63693f);
        }
    }

    public void h() {
        SkinManager.setBackgroundColor(this.f63694g, R.color.CAM_X0201);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f63695h && this.f63692e != null) {
            InterestedForumFragment interestedForumFragment = this.k;
            if (interestedForumFragment != null && interestedForumFragment.isVisible()) {
                b().popBackStack();
                d.a.k0.z1.d.a.b(1, this.f63693f);
                return;
            }
            d();
        } else if (view == this.f63696i) {
            d();
            d.a.k0.z1.d.a.a(b().getFragments().size() != 1 ? 2 : 1, 2, this.f63693f);
        }
    }
}
