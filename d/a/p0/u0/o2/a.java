package d.a.p0.u0.o2;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f63367e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63368f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f63369g;

    /* renamed from: h  reason: collision with root package name */
    public View f63370h;

    /* renamed from: i  reason: collision with root package name */
    public PopupWindow f63371i;
    public Handler j;
    public Runnable k;

    /* renamed from: d.a.p0.u0.o2.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1705a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63372e;

        /* renamed from: d.a.p0.u0.o2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1706a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ RunnableC1705a f63373e;

            public RunnableC1706a(RunnableC1705a runnableC1705a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1705a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f63373e = runnableC1705a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f63373e.f63372e.f63371i == null) {
                    return;
                }
                this.f63373e.f63372e.j();
            }
        }

        public RunnableC1705a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63372e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f63372e.f63369g == null || this.f63372e.f63370h == null) {
                return;
            }
            Activity pageActivity = this.f63372e.f63369g.getPageActivity();
            int g2 = d.a.c.e.p.l.g(pageActivity, R.dimen.ds64);
            a aVar = this.f63372e;
            View h2 = aVar.h(pageActivity, aVar.f63367e);
            int[] iArr = new int[2];
            this.f63372e.f63370h.getLocationInWindow(iArr);
            int g3 = d.a.c.e.p.l.g(pageActivity, R.dimen.ds32);
            int g4 = (iArr[1] - g2) + d.a.c.e.p.l.g(pageActivity, R.dimen.ds16);
            this.f63372e.f63371i = new PopupWindow(h2, -2, g2);
            this.f63372e.f63371i.showAtLocation(this.f63372e.f63370h, 53, g3, g4);
            this.f63372e.j.postDelayed(new RunnableC1706a(this), 3000L);
        }
    }

    public a(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63367e = R.string.attention_post_update_tip;
        this.j = new Handler();
        this.k = new RunnableC1705a(this);
        this.f63369g = tbPageContext;
        this.f63368f = z;
    }

    public final View h(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, activity, i2)) == null) {
            TextView textView = new TextView(activity);
            int g2 = d.a.c.e.p.l.g(activity, R.dimen.ds20);
            textView.setPadding(g2, 0 - activity.getResources().getDimensionPixelSize(R.dimen.ds12), g2, 0);
            textView.setHeight(activity.getResources().getDimensionPixelSize(R.dimen.ds76));
            textView.setGravity(17);
            textView.setTextSize(0, d.a.c.e.p.l.g(activity, R.dimen.fontsize28));
            textView.setText(i2);
            textView.setOnClickListener(this);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_tip_blue_left);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
            textView.setOnClickListener(this);
            return textView;
        }
        return (View) invokeLI.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.j.removeCallbacksAndMessages(null);
            j();
        }
    }

    public void j() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (popupWindow = this.f63371i) == null) {
            return;
        }
        popupWindow.dismiss();
        this.f63371i = null;
    }

    public void k(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (this.f63369g == null || view == null || StringUtils.isNull(currentAccount)) {
                return;
            }
            this.f63370h = view;
            if (this.f63368f) {
                this.f63367e = R.string.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int k = d.a.o0.r.d0.b.j().k(str, 0);
                if (k >= 3) {
                    this.f63368f = false;
                    return;
                }
                d.a.o0.r.d0.b.j().v(str, k + 1);
                this.f63368f = false;
                this.j.postDelayed(this.k, 500L);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            j();
        }
    }
}
