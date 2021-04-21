package d.b.j0.q0.n2;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<BaseFragmentActivity> f60174a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f60175b;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.f60174a = tbPageContext;
        this.f60175b = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.frs_like);
    }
}
