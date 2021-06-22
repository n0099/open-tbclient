package d.a.o0.r0.n2;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<BaseFragmentActivity> f62954a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f62955b;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.f62954a = tbPageContext;
        this.f62955b = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.frs_like);
    }
}
