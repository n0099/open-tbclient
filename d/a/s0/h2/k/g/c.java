package d.a.s0.h2.k.g;

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
import d.a.c.e.p.k;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.r0.r.q.b2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.s0.h2.k.g.e.b f60861a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f60862b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f60863c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f60864d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.k.e.a> f60865e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f60866f;

    /* renamed from: g  reason: collision with root package name */
    public w f60867g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60868h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60869i;

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
        this.f60865e = new ArrayList();
        this.f60866f = null;
        this.f60868h = false;
        this.f60869i = true;
        this.f60863c = newSubPbActivity;
        this.f60864d = bdTypeListView;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60868h : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.s0.h2.k.g.e.b bVar = new d.a.s0.h2.k.g.e.b(this.f60863c, PostData.u0);
            this.f60861a = bVar;
            bVar.e(this.f60866f);
            this.f60861a.a0(this.f60867g);
            this.f60861a.setFromCDN(this.f60869i);
            this.f60865e.add(this.f60861a);
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f60863c, d.a.s0.h2.k.g.f.b.f60889f);
            this.f60862b = subPbReplyAdapter;
            this.f60865e.add(subPbReplyAdapter);
            this.f60865e.add(new d.a.s0.h2.k.g.e.c(this.f60863c, d.a.s0.h2.k.g.f.a.f60888e));
            this.f60864d.a(this.f60865e);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f60864d.getAdapter2() == null) {
            return;
        }
        this.f60864d.getAdapter2().notifyDataSetChanged();
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f60866f = onClickListener;
        }
    }

    public void e(b2 b2Var, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, b2Var, list) == null) {
            this.f60861a.w0(b2Var);
            if (!k.isEmpty(this.f60863c.getSubPbModel().c0())) {
                this.f60861a.v0(this.f60863c.getSubPbModel().c0());
            }
            NewSubPbActivity newSubPbActivity = this.f60863c;
            if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
                this.f60861a.t0(this.f60863c.getSubPbModel().u0());
            }
            this.f60864d.setData(list);
            this.f60864d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f60869i = z;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f60868h = z;
        }
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.f60861a.d(onLongClickListener);
        }
    }

    public void i(TbRichTextView.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xVar) == null) {
            this.f60861a.p(xVar);
        }
    }
}
