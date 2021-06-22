package d.a.o0.a2.f;

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
import d.a.o0.a2.c.b;
import java.util.List;
/* loaded from: classes5.dex */
public class a implements View.OnClickListener, InterestSelectionFragment.a {

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f54985e;

    /* renamed from: f  reason: collision with root package name */
    public int f54986f;

    /* renamed from: g  reason: collision with root package name */
    public View f54987g;

    /* renamed from: h  reason: collision with root package name */
    public View f54988h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f54989i;
    public NavigationBar j;
    public InterestedForumFragment k;
    public InterestSelectionFragment l;

    public a(BaseFragmentActivity baseFragmentActivity, int i2) {
        this.f54985e = baseFragmentActivity;
        this.f54986f = i2;
        e();
        f();
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void a(List<b> list) {
        InterestedForumFragment G0 = InterestedForumFragment.G0(this.f54986f);
        this.k = G0;
        G0.M0(list);
        b().beginTransaction().add(R.id.content_container, this.k).addToBackStack(null).commitAllowingStateLoss();
        d.a.o0.a2.d.a.a(b().getFragments().size() == 1 ? 1 : 2, 1, this.f54986f);
    }

    public final FragmentManager b() {
        return this.f54985e.getSupportFragmentManager();
    }

    public View c() {
        return this.f54987g;
    }

    public final void d() {
        StatisticItem statisticItem = new StatisticItem("c13682");
        statisticItem.param("obj_type", 1);
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.f54985e).createNormalCfg(0)));
    }

    public final void e() {
        View inflate = LayoutInflater.from(this.f54985e).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.f54987g = inflate;
        NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
        this.j = navigationBar;
        TextView addTextButton = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f54985e.getString(R.string.skip));
        this.f54989i = addTextButton;
        addTextButton.setId(R.id.btn_skip);
        SkinManager.setViewTextColor(this.f54989i, R.color.CAM_X0107);
        this.f54988h = this.j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.l = InterestSelectionFragment.G0(this.f54986f);
        b().beginTransaction().add(R.id.content_container, this.l).commitAllowingStateLoss();
        TiebaStatic.log(new StatisticItem("c13681"));
    }

    public final void f() {
        this.f54989i.setOnClickListener(this);
        this.f54988h.setOnClickListener(this);
        this.l.J0(this);
    }

    public void h() {
        if (b().getFragments().size() == 1) {
            d.a.o0.a2.d.a.b(1, this.f54986f);
        }
    }

    public void i() {
        SkinManager.setBackgroundColor(this.f54987g, R.color.CAM_X0201);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f54988h && this.f54985e != null) {
            InterestedForumFragment interestedForumFragment = this.k;
            if (interestedForumFragment != null && interestedForumFragment.isVisible()) {
                b().popBackStack();
                d.a.o0.a2.d.a.b(1, this.f54986f);
                return;
            }
            d();
        } else if (view == this.f54989i) {
            d();
            d.a.o0.a2.d.a.a(b().getFragments().size() != 1 ? 2 : 1, 2, this.f54986f);
        }
    }
}
