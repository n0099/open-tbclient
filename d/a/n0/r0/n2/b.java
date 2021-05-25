package d.a.n0.r0.n2;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<BaseFragmentActivity> f59138a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f59139b;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.f59138a = tbPageContext;
        this.f59139b = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.frs_like);
    }
}
