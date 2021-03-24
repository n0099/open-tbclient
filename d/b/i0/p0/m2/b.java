package d.b.i0.p0.m2;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<BaseFragmentActivity> f57903a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f57904b;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.f57903a = tbPageContext;
        this.f57904b = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.frs_like);
    }
}
