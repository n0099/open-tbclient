package d.a.s0.h2.j;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.s0.h2.j.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AlertDialog f60212a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f60213b;

    /* renamed from: c  reason: collision with root package name */
    public Context f60214c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnKeyListener f60215d;

    /* renamed from: e  reason: collision with root package name */
    public DialogInterface.OnCancelListener f60216e;

    /* renamed from: f  reason: collision with root package name */
    public int f60217f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60218g;

    /* renamed from: h  reason: collision with root package name */
    public V f60219h;

    /* renamed from: d.a.s0.h2.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1453a implements ViewHelper.ViewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f60220a;

        public C1453a(a aVar, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60220a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (view instanceof EditText) {
                    this.f60220a.set(true);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public a(TbPageContext tbPageContext, V v, D d2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, v, d2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60217f = -1;
        this.f60218g = false;
        this.f60213b = tbPageContext;
        this.f60214c = tbPageContext.getPageActivity();
        this.f60219h = v;
        d(d2);
    }

    public void d(D d2) {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, d2) == null) || (v = this.f60219h) == null) {
            return;
        }
        v.b(d2);
    }

    @Override // d.a.s0.h2.j.f
    public void dismiss() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alertDialog = this.f60212a) == null) {
            return;
        }
        d.a.c.e.m.g.a(alertDialog, this.f60213b.getPageActivity());
    }

    @Override // d.a.s0.h2.j.f
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AlertDialog alertDialog = this.f60212a;
            if (alertDialog != null) {
                d.a.c.e.m.g.i(alertDialog, this.f60213b.getPageActivity());
                return;
            }
            if (this.f60218g) {
                this.f60212a = new AlertDialog.Builder(this.f60214c, R.style.search_dialog).create();
            } else {
                this.f60212a = new AlertDialog.Builder(this.f60214c).create();
            }
            this.f60212a.setCanceledOnTouchOutside(c());
            this.f60212a.setCancelable(b());
            this.f60212a.setOnKeyListener(this.f60215d);
            DialogInterface.OnCancelListener onCancelListener = this.f60216e;
            if (onCancelListener != null) {
                this.f60212a.setOnCancelListener(onCancelListener);
            }
            d.a.c.e.m.g.i(this.f60212a, this.f60213b.getPageActivity());
            if (this.f60212a.getWindow().getDecorView().getParent() == null) {
                return;
            }
            Window window = this.f60212a.getWindow();
            if (this.f60217f == -1) {
                this.f60217f = 17;
            }
            window.setGravity(this.f60217f);
            window.setBackgroundDrawableResource(R.drawable.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics q = l.q(this.f60213b.getPageActivity());
            if (q != null) {
                int a2 = a();
                if (UtilHelper.getRealScreenOrientation(this.f60214c) == 2) {
                    attributes.width = q.heightPixels - (a2 * 2);
                } else {
                    attributes.width = q.widthPixels - (a2 * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.f60219h.getViewGroup());
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ViewHelper.processAllViewsIn(this.f60219h.getViewGroup(), false, new C1453a(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
    }
}
