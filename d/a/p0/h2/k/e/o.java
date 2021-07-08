package d.a.p0.h2.k.e;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class o<T, V extends TypeAdapter.ViewHolder> extends d.a.c.k.e.a<T, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.p0.h2.o.b m;
    public PbFragment n;
    public VideoPbFragment o;
    public int p;
    public boolean q;
    public SparseIntArray r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(d.a.p0.h2.o.b bVar, BdUniqueId bdUniqueId) {
        super(bVar == null ? null : bVar.z(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = 3;
        this.q = false;
        new SparseArray();
        this.r = new SparseIntArray();
        g0(bVar);
    }

    @Override // d.a.c.k.e.a
    public View X(int i2, View view, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), view, viewGroup, t, v})) == null) {
            this.p = TbadkCoreApplication.getInst().getSkinType();
            d.a.c.k.e.p pVar = (d.a.c.k.e.p) viewGroup;
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public int f0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int i3 = this.r.get(i2, -1);
            if (i3 != -1) {
                return i3;
            }
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i2);
            this.r.put(i2, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return invokeI.intValue;
    }

    public void g0(d.a.p0.h2.o.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
            return;
        }
        this.m = bVar;
        this.n = bVar.C0();
        VideoPbFragment v = bVar.v();
        this.o = v;
        PbFragment pbFragment = this.n;
        if (pbFragment != null) {
            this.f41837e = pbFragment.getActivity();
        } else if (v != null) {
            this.f41837e = v.getActivity();
        } else {
            this.f41837e = null;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.q = z;
        }
    }
}
