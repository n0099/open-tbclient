package d.b.j0.z1.f;

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
import d.b.j0.z1.c.b;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener, InterestSelectionFragment.a {

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f64684e;

    /* renamed from: f  reason: collision with root package name */
    public int f64685f;

    /* renamed from: g  reason: collision with root package name */
    public View f64686g;

    /* renamed from: h  reason: collision with root package name */
    public View f64687h;
    public TextView i;
    public NavigationBar j;
    public InterestedForumFragment k;
    public InterestSelectionFragment l;

    public a(BaseFragmentActivity baseFragmentActivity, int i) {
        this.f64684e = baseFragmentActivity;
        this.f64685f = i;
        e();
        f();
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void a(List<b> list) {
        InterestedForumFragment E0 = InterestedForumFragment.E0(this.f64685f);
        this.k = E0;
        E0.K0(list);
        b().beginTransaction().add(R.id.content_container, this.k).addToBackStack(null).commitAllowingStateLoss();
        d.b.j0.z1.d.a.a(b().getFragments().size() == 1 ? 1 : 2, 1, this.f64685f);
    }

    public final FragmentManager b() {
        return this.f64684e.getSupportFragmentManager();
    }

    public View c() {
        return this.f64686g;
    }

    public final void d() {
        StatisticItem statisticItem = new StatisticItem("c13682");
        statisticItem.param("obj_type", 1);
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.f64684e).createNormalCfg(0)));
    }

    public final void e() {
        View inflate = LayoutInflater.from(this.f64684e).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.f64686g = inflate;
        NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
        this.j = navigationBar;
        TextView addTextButton = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f64684e.getString(R.string.skip));
        this.i = addTextButton;
        addTextButton.setId(R.id.btn_skip);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0107);
        this.f64687h = this.j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.l = InterestSelectionFragment.E0(this.f64685f);
        b().beginTransaction().add(R.id.content_container, this.l).commitAllowingStateLoss();
        TiebaStatic.log(new StatisticItem("c13681"));
    }

    public final void f() {
        this.i.setOnClickListener(this);
        this.f64687h.setOnClickListener(this);
        this.l.H0(this);
    }

    public void h() {
        if (b().getFragments().size() == 1) {
            d.b.j0.z1.d.a.b(1, this.f64685f);
        }
    }

    public void i() {
        SkinManager.setBackgroundColor(this.f64686g, R.color.CAM_X0201);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f64687h && this.f64684e != null) {
            InterestedForumFragment interestedForumFragment = this.k;
            if (interestedForumFragment != null && interestedForumFragment.isVisible()) {
                b().popBackStack();
                d.b.j0.z1.d.a.b(1, this.f64685f);
                return;
            }
            d();
        } else if (view == this.i) {
            d();
            d.b.j0.z1.d.a.a(b().getFragments().size() != 1 ? 2 : 1, 2, this.f64685f);
        }
    }
}
