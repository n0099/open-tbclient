package d.b.i0.y1.f;

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
import d.b.i0.y1.c.b;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener, InterestSelectionFragment.a {

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f62602e;

    /* renamed from: f  reason: collision with root package name */
    public int f62603f;

    /* renamed from: g  reason: collision with root package name */
    public View f62604g;

    /* renamed from: h  reason: collision with root package name */
    public View f62605h;
    public TextView i;
    public NavigationBar j;
    public InterestedForumFragment k;
    public InterestSelectionFragment l;

    public a(BaseFragmentActivity baseFragmentActivity, int i) {
        this.f62602e = baseFragmentActivity;
        this.f62603f = i;
        e();
        f();
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void a(List<b> list) {
        InterestedForumFragment E0 = InterestedForumFragment.E0(this.f62603f);
        this.k = E0;
        E0.K0(list);
        b().beginTransaction().add(R.id.content_container, this.k).addToBackStack(null).commitAllowingStateLoss();
        d.b.i0.y1.d.a.a(b().getFragments().size() == 1 ? 1 : 2, 1, this.f62603f);
    }

    public final FragmentManager b() {
        return this.f62602e.getSupportFragmentManager();
    }

    public View c() {
        return this.f62604g;
    }

    public final void d() {
        StatisticItem statisticItem = new StatisticItem("c13682");
        statisticItem.param("obj_type", 1);
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.f62602e).createNormalCfg(0)));
    }

    public final void e() {
        View inflate = LayoutInflater.from(this.f62602e).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.f62604g = inflate;
        NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
        this.j = navigationBar;
        TextView addTextButton = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f62602e.getString(R.string.skip));
        this.i = addTextButton;
        addTextButton.setId(R.id.btn_skip);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0107);
        this.f62605h = this.j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.l = InterestSelectionFragment.E0(this.f62603f);
        b().beginTransaction().add(R.id.content_container, this.l).commitAllowingStateLoss();
        TiebaStatic.log(new StatisticItem("c13681"));
    }

    public final void f() {
        this.i.setOnClickListener(this);
        this.f62605h.setOnClickListener(this);
        this.l.H0(this);
    }

    public void h() {
        if (b().getFragments().size() == 1) {
            d.b.i0.y1.d.a.b(1, this.f62603f);
        }
    }

    public void i() {
        SkinManager.setBackgroundColor(this.f62604g, R.color.CAM_X0201);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f62605h && this.f62602e != null) {
            InterestedForumFragment interestedForumFragment = this.k;
            if (interestedForumFragment != null && interestedForumFragment.isVisible()) {
                b().popBackStack();
                d.b.i0.y1.d.a.b(1, this.f62603f);
                return;
            }
            d();
        } else if (view == this.i) {
            d();
            d.b.i0.y1.d.a.a(b().getFragments().size() != 1 ? 2 : 1, 2, this.f62603f);
        }
    }
}
