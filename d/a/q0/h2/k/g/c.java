package d.a.q0.h2.k.g;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import d.a.d.k.e.n;
import d.a.d.k.e.w;
import d.a.p0.s.q.b2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.h2.k.g.e.b f58189a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f58190b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f58191c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f58192d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.d.k.e.a> f58193e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f58194f;

    /* renamed from: g  reason: collision with root package name */
    public w f58195g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58196h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58197i;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newSubPbActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58193e = new ArrayList();
        this.f58194f = null;
        this.f58196h = false;
        this.f58197i = true;
        this.f58191c = newSubPbActivity;
        this.f58192d = bdTypeListView;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f58196h : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.q0.h2.k.g.e.b bVar = new d.a.q0.h2.k.g.e.b(this.f58191c, PostData.u0);
            this.f58189a = bVar;
            bVar.e(this.f58194f);
            this.f58189a.a0(this.f58195g);
            this.f58189a.setFromCDN(this.f58197i);
            this.f58193e.add(this.f58189a);
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f58191c, d.a.q0.h2.k.g.f.b.f58217f);
            this.f58190b = subPbReplyAdapter;
            this.f58193e.add(subPbReplyAdapter);
            this.f58193e.add(new d.a.q0.h2.k.g.e.c(this.f58191c, d.a.q0.h2.k.g.f.a.f58216e));
            this.f58192d.a(this.f58193e);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f58192d.getAdapter2() == null) {
            return;
        }
        this.f58192d.getAdapter2().notifyDataSetChanged();
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f58194f = onClickListener;
        }
    }

    public void e(b2 b2Var, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, b2Var, list) == null) {
            this.f58189a.u0(b2Var);
            if (!k.isEmpty(this.f58191c.getSubPbModel().m0())) {
                this.f58189a.t0(this.f58191c.getSubPbModel().m0());
            }
            NewSubPbActivity newSubPbActivity = this.f58191c;
            if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
                this.f58189a.r0(this.f58191c.getSubPbModel().F0());
            }
            this.f58192d.setData(list);
            this.f58192d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f58197i = z;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f58196h = z;
        }
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.f58189a.d(onLongClickListener);
        }
    }

    public void i(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zVar) == null) {
            this.f58189a.p(zVar);
        }
    }
}
