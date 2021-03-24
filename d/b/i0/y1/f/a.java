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
/* loaded from: classes4.dex */
public class a implements View.OnClickListener, InterestSelectionFragment.a {

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f62601e;

    /* renamed from: f  reason: collision with root package name */
    public int f62602f;

    /* renamed from: g  reason: collision with root package name */
    public View f62603g;

    /* renamed from: h  reason: collision with root package name */
    public View f62604h;
    public TextView i;
    public NavigationBar j;
    public InterestedForumFragment k;
    public InterestSelectionFragment l;

    public a(BaseFragmentActivity baseFragmentActivity, int i) {
        this.f62601e = baseFragmentActivity;
        this.f62602f = i;
        e();
        f();
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void a(List<b> list) {
        InterestedForumFragment interestedForumFragment = new InterestedForumFragment(this.f62602f);
        this.k = interestedForumFragment;
        interestedForumFragment.J0(list);
        b().beginTransaction().add(R.id.content_container, this.k).addToBackStack(null).commitAllowingStateLoss();
        d.b.i0.y1.d.a.a(b().getFragments().size() == 1 ? 1 : 2, 1, this.f62602f);
    }

    public final FragmentManager b() {
        return this.f62601e.getSupportFragmentManager();
    }

    public View c() {
        return this.f62603g;
    }

    public final void d() {
        StatisticItem statisticItem = new StatisticItem("c13682");
        statisticItem.param("obj_type", 1);
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.f62601e).createNormalCfg(0)));
    }

    public final void e() {
        View inflate = LayoutInflater.from(this.f62601e).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
        this.f62603g = inflate;
        NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
        this.j = navigationBar;
        TextView addTextButton = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f62601e.getString(R.string.skip));
        this.i = addTextButton;
        addTextButton.setId(R.id.btn_skip);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0107);
        this.f62604h = this.j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.l = new InterestSelectionFragment(this.f62602f);
        b().beginTransaction().add(R.id.content_container, this.l).commitAllowingStateLoss();
        TiebaStatic.log(new StatisticItem("c13681"));
    }

    public final void f() {
        this.i.setOnClickListener(this);
        this.f62604h.setOnClickListener(this);
        this.l.G0(this);
    }

    public void h() {
        if (b().getFragments().size() == 1) {
            d.b.i0.y1.d.a.b(1, this.f62602f);
        }
    }

    public void i() {
        SkinManager.setBackgroundColor(this.f62603g, R.color.CAM_X0201);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f62604h && this.f62601e != null) {
            InterestedForumFragment interestedForumFragment = this.k;
            if (interestedForumFragment != null && interestedForumFragment.isVisible()) {
                b().popBackStack();
                d.b.i0.y1.d.a.b(1, this.f62602f);
                return;
            }
            d();
        } else if (view == this.i) {
            d();
            d.b.i0.y1.d.a.a(b().getFragments().size() != 1 ? 2 : 1, 2, this.f62602f);
        }
    }
}
