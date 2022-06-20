package com.repackage;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.yq4;
/* loaded from: classes5.dex */
public class eu7 extends wq4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TbPageContext<?> w;
    public View.OnClickListener x;

    /* loaded from: classes5.dex */
    public class a implements yq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eu7 a;

        public a(eu7 eu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eu7Var;
        }

        @Override // com.repackage.yq4.e
        public void W(yq4 yq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yq4Var, i, view2) == null) {
                this.a.dismiss();
                this.a.x.onClick(view2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eu7(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = tbPageContext;
        this.x = onClickListener;
        r();
    }

    public TextView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public TextView B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.r : (TextView) invokeV.objValue;
    }

    public TextView C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.u : (TextView) invokeV.objValue;
    }

    public TextView D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : (TextView) invokeV.objValue;
    }

    public TextView E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.q : (TextView) invokeV.objValue;
    }

    public TextView F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.v : (TextView) invokeV.objValue;
    }

    public View G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? h() : (View) invokeV.objValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.m.setVisibility(z ? 0 : 8);
        }
    }

    public void p(SparseArray<Object> sparseArray, int i, boolean z, hr7 hr7Var) {
        TbPageContext<?> tbPageContext;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{sparseArray, Integer.valueOf(i), Boolean.valueOf(z), hr7Var}) == null) || sparseArray == null) {
            return;
        }
        PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e49);
        if (postData.q() != null) {
            boolean z2 = postData.q().hasAgree;
            int r = postData.r();
            if (z2 && r == 5) {
                tbPageContext = this.w;
                i2 = R.string.obfuscated_res_0x7f0f0085;
            } else {
                tbPageContext = this.w;
                i2 = R.string.obfuscated_res_0x7f0f0087;
            }
            String string = tbPageContext.getString(i2);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.obfuscated_res_0x7f091e49, postData);
            v().setTag(sparseArray2);
            v().setVisibility(0);
            v().setText(string);
        }
        boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091e8c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e8c)).booleanValue() : false;
        boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091ea0) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea0)).booleanValue() : false;
        boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091e8a) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e8a)).booleanValue() : false;
        boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091e4c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue() : false;
        boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091e61) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e61)).booleanValue() : false;
        String str = sparseArray.get(R.id.obfuscated_res_0x7f091e59) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e59) : null;
        if (booleanValue) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.obfuscated_res_0x7f091e8c, Boolean.TRUE);
            sparseArray3.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
            sparseArray3.put(R.id.obfuscated_res_0x7f091e56, sparseArray.get(R.id.obfuscated_res_0x7f091e56));
            sparseArray3.put(R.id.obfuscated_res_0x7f091e57, sparseArray.get(R.id.obfuscated_res_0x7f091e57));
            sparseArray3.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
            sparseArray3.put(R.id.obfuscated_res_0x7f091e59, str);
            if (!lw7.i(hr7Var) && booleanValue2) {
                sparseArray3.put(R.id.obfuscated_res_0x7f091ea0, Boolean.TRUE);
                sparseArray3.put(R.id.obfuscated_res_0x7f091e60, sparseArray.get(R.id.obfuscated_res_0x7f091e60));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e9c, sparseArray.get(R.id.obfuscated_res_0x7f091e9c));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e9d, sparseArray.get(R.id.obfuscated_res_0x7f091e9d));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e9b, sparseArray.get(R.id.obfuscated_res_0x7f091e9b));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e9e, sparseArray.get(R.id.obfuscated_res_0x7f091e9e));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e9f, sparseArray.get(R.id.obfuscated_res_0x7f091e9f));
            } else {
                sparseArray3.put(R.id.obfuscated_res_0x7f091ea0, Boolean.FALSE);
            }
            if (booleanValue3) {
                sparseArray3.put(R.id.obfuscated_res_0x7f091e8a, Boolean.TRUE);
                sparseArray3.put(R.id.obfuscated_res_0x7f091e4c, Boolean.valueOf(booleanValue4));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e4b, sparseArray.get(R.id.obfuscated_res_0x7f091e4b));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e4d, sparseArray.get(R.id.obfuscated_res_0x7f091e4d));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e5d, sparseArray.get(R.id.obfuscated_res_0x7f091e5d));
                if (booleanValue5) {
                    u().setVisibility(0);
                } else {
                    u().setVisibility(8);
                }
            } else {
                sparseArray3.put(R.id.obfuscated_res_0x7f091e8a, Boolean.FALSE);
                u().setVisibility(8);
            }
            z().setTag(sparseArray3);
            u().setTag(sparseArray3);
            z().setText(R.string.obfuscated_res_0x7f0f02db);
            z().setVisibility(0);
        } else if (booleanValue3) {
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(R.id.obfuscated_res_0x7f091e8c, Boolean.FALSE);
            sparseArray4.put(R.id.obfuscated_res_0x7f091ea0, Boolean.FALSE);
            sparseArray4.put(R.id.obfuscated_res_0x7f091e8a, Boolean.TRUE);
            sparseArray4.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
            sparseArray4.put(R.id.obfuscated_res_0x7f091e4c, Boolean.valueOf(booleanValue4));
            sparseArray4.put(R.id.obfuscated_res_0x7f091e4b, sparseArray.get(R.id.obfuscated_res_0x7f091e4b));
            sparseArray4.put(R.id.obfuscated_res_0x7f091e4d, sparseArray.get(R.id.obfuscated_res_0x7f091e4d));
            sparseArray4.put(R.id.obfuscated_res_0x7f091e5d, sparseArray.get(R.id.obfuscated_res_0x7f091e5d));
            z().setTag(sparseArray4);
            u().setTag(sparseArray4);
            z().setText(R.string.obfuscated_res_0x7f0f0496);
            u().setVisibility(0);
            if (i == 1002 && !booleanValue4) {
                u().setText(R.string.obfuscated_res_0x7f0f0fdb);
            } else {
                u().setText(R.string.obfuscated_res_0x7f0f0496);
            }
            z().setVisibility(8);
        } else {
            z().setVisibility(8);
            u().setVisibility(8);
        }
        boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f091ea0) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea0)).booleanValue() : false;
        boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091e8c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e8c)).booleanValue() : false;
        if (!lw7.i(hr7Var) && !booleanValue7 && booleanValue6) {
            SparseArray sparseArray5 = new SparseArray();
            sparseArray5.put(R.id.obfuscated_res_0x7f091ea0, Boolean.TRUE);
            sparseArray5.put(R.id.obfuscated_res_0x7f091e60, sparseArray.get(R.id.obfuscated_res_0x7f091e60));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e9c, sparseArray.get(R.id.obfuscated_res_0x7f091e9c));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e9d, sparseArray.get(R.id.obfuscated_res_0x7f091e9d));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e9b, sparseArray.get(R.id.obfuscated_res_0x7f091e9b));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e9e, sparseArray.get(R.id.obfuscated_res_0x7f091e9e));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e9f, sparseArray.get(R.id.obfuscated_res_0x7f091e9f));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e4c, sparseArray.get(R.id.obfuscated_res_0x7f091e4c));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e4d, sparseArray.get(R.id.obfuscated_res_0x7f091e4d));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e4b, sparseArray.get(R.id.obfuscated_res_0x7f091e4b));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
            D().setTag(sparseArray5);
            D().setVisibility(0);
            z().setVisibility(8);
            D().setText(R.string.obfuscated_res_0x7f0f0b33);
        } else {
            if (sparseArray.get(R.id.obfuscated_res_0x7f091e4c) instanceof Boolean) {
                ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue();
            }
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f091e59) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e59) : null;
            if (z) {
                D().setVisibility(0);
                D().setTag(str2);
            } else {
                D().setVisibility(8);
            }
        }
        B().setVisibility(8);
        t().setVisibility(8);
        w().setVisibility(8);
        A().setVisibility(8);
        E().setVisibility(8);
        lw7.l(this.t, postData, hr7Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(SparseArray<Object> sparseArray, int i, boolean z, boolean z2, hr7 hr7Var) {
        boolean z3;
        boolean booleanValue;
        int i2;
        int i3;
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{sparseArray, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), hr7Var}) == null) || sparseArray == null) {
            return;
        }
        PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e49);
        SparseArray sparseArray2 = new SparseArray();
        sparseArray2.put(R.id.obfuscated_res_0x7f091e49, (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e49));
        sparseArray2.put(R.id.obfuscated_res_0x7f091e62, Boolean.FALSE);
        A().setTag(sparseArray2);
        SparseArray sparseArray3 = new SparseArray();
        sparseArray3.put(R.id.obfuscated_res_0x7f091e49, (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e49));
        t().setTag(sparseArray3);
        boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091e8c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e8c)).booleanValue() : false;
        boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091ea0) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea0)).booleanValue() : false;
        boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091e8a) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e8a)).booleanValue() : false;
        boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091e4c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue() : false;
        boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f091e61) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e61)).booleanValue() : false;
        String str = sparseArray.get(R.id.obfuscated_res_0x7f091e59) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e59) : null;
        if (booleanValue2) {
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(R.id.obfuscated_res_0x7f091e8c, Boolean.TRUE);
            sparseArray4.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
            sparseArray4.put(R.id.obfuscated_res_0x7f091e56, sparseArray.get(R.id.obfuscated_res_0x7f091e56));
            sparseArray4.put(R.id.obfuscated_res_0x7f091e57, sparseArray.get(R.id.obfuscated_res_0x7f091e57));
            sparseArray4.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
            sparseArray4.put(R.id.obfuscated_res_0x7f091e59, str);
            if (!lw7.i(hr7Var) && booleanValue3) {
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea0, Boolean.TRUE);
                sparseArray4.put(R.id.obfuscated_res_0x7f091e60, sparseArray.get(R.id.obfuscated_res_0x7f091e60));
                sparseArray4.put(R.id.obfuscated_res_0x7f091e9c, sparseArray.get(R.id.obfuscated_res_0x7f091e9c));
                sparseArray4.put(R.id.obfuscated_res_0x7f091e9d, sparseArray.get(R.id.obfuscated_res_0x7f091e9d));
                sparseArray4.put(R.id.obfuscated_res_0x7f091e9b, sparseArray.get(R.id.obfuscated_res_0x7f091e9b));
                sparseArray4.put(R.id.obfuscated_res_0x7f091e9e, sparseArray.get(R.id.obfuscated_res_0x7f091e9e));
                sparseArray4.put(R.id.obfuscated_res_0x7f091e9f, sparseArray.get(R.id.obfuscated_res_0x7f091e9f));
            } else {
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea0, Boolean.FALSE);
            }
            if (booleanValue4) {
                sparseArray4.put(R.id.obfuscated_res_0x7f091e8a, Boolean.TRUE);
                sparseArray4.put(R.id.obfuscated_res_0x7f091e4c, Boolean.valueOf(booleanValue5));
                sparseArray4.put(R.id.obfuscated_res_0x7f091e4b, sparseArray.get(R.id.obfuscated_res_0x7f091e4b));
                sparseArray4.put(R.id.obfuscated_res_0x7f091e4d, sparseArray.get(R.id.obfuscated_res_0x7f091e4d));
                sparseArray4.put(R.id.obfuscated_res_0x7f091e5d, sparseArray.get(R.id.obfuscated_res_0x7f091e5d));
                if (booleanValue6) {
                    u().setVisibility(0);
                } else {
                    u().setVisibility(8);
                }
            } else {
                sparseArray4.put(R.id.obfuscated_res_0x7f091e8a, Boolean.FALSE);
                u().setVisibility(8);
            }
            z().setTag(sparseArray4);
            u().setTag(sparseArray4);
            z().setText(R.string.obfuscated_res_0x7f0f02db);
            z().setVisibility(0);
        } else if (booleanValue4) {
            SparseArray sparseArray5 = new SparseArray();
            sparseArray5.put(R.id.obfuscated_res_0x7f091e8c, Boolean.FALSE);
            sparseArray5.put(R.id.obfuscated_res_0x7f091ea0, Boolean.FALSE);
            sparseArray5.put(R.id.obfuscated_res_0x7f091e8a, Boolean.TRUE);
            sparseArray5.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e4c, Boolean.valueOf(booleanValue5));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e4b, sparseArray.get(R.id.obfuscated_res_0x7f091e4b));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e4d, sparseArray.get(R.id.obfuscated_res_0x7f091e4d));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e5d, sparseArray.get(R.id.obfuscated_res_0x7f091e5d));
            z().setTag(sparseArray5);
            u().setTag(sparseArray5);
            z().setText(R.string.obfuscated_res_0x7f0f0496);
            u().setVisibility(0);
            if (i == 1002 && !booleanValue5) {
                u().setText(R.string.obfuscated_res_0x7f0f0fdb);
            } else {
                u().setText(R.string.obfuscated_res_0x7f0f0496);
            }
            z().setVisibility(8);
        } else {
            z().setVisibility(8);
            u().setVisibility(8);
        }
        boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091ea0) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea0)).booleanValue() : false;
        boolean booleanValue8 = sparseArray.get(R.id.obfuscated_res_0x7f091e8c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e8c)).booleanValue() : false;
        if (!lw7.i(hr7Var) && !booleanValue8 && booleanValue7) {
            SparseArray sparseArray6 = new SparseArray();
            sparseArray6.put(R.id.obfuscated_res_0x7f091ea0, Boolean.TRUE);
            sparseArray6.put(R.id.obfuscated_res_0x7f091e60, sparseArray.get(R.id.obfuscated_res_0x7f091e60));
            sparseArray6.put(R.id.obfuscated_res_0x7f091e9c, sparseArray.get(R.id.obfuscated_res_0x7f091e9c));
            sparseArray6.put(R.id.obfuscated_res_0x7f091e9d, sparseArray.get(R.id.obfuscated_res_0x7f091e9d));
            sparseArray6.put(R.id.obfuscated_res_0x7f091e9b, sparseArray.get(R.id.obfuscated_res_0x7f091e9b));
            sparseArray6.put(R.id.obfuscated_res_0x7f091e9e, sparseArray.get(R.id.obfuscated_res_0x7f091e9e));
            sparseArray6.put(R.id.obfuscated_res_0x7f091e9f, sparseArray.get(R.id.obfuscated_res_0x7f091e9f));
            sparseArray6.put(R.id.obfuscated_res_0x7f091e4c, sparseArray.get(R.id.obfuscated_res_0x7f091e4c));
            sparseArray6.put(R.id.obfuscated_res_0x7f091e4d, sparseArray.get(R.id.obfuscated_res_0x7f091e4d));
            sparseArray6.put(R.id.obfuscated_res_0x7f091e4b, sparseArray.get(R.id.obfuscated_res_0x7f091e4b));
            sparseArray6.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
            D().setTag(sparseArray6);
            D().setVisibility(0);
            z().setVisibility(8);
            D().setText(R.string.obfuscated_res_0x7f0f0b33);
        } else {
            if (sparseArray.get(R.id.obfuscated_res_0x7f091e4c) instanceof Boolean) {
                ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue();
            }
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f091e59) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e59) : null;
            if (z) {
                D().setVisibility(0);
                D().setTag(str2);
            } else {
                D().setVisibility(8);
            }
        }
        boolean booleanValue9 = sparseArray.get(R.id.obfuscated_res_0x7f091e8b) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e8b)).booleanValue() : false;
        long longValue = sparseArray.get(R.id.obfuscated_res_0x7f091e48) instanceof Long ? ((Long) sparseArray.get(R.id.obfuscated_res_0x7f091e48)).longValue() : 0L;
        String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091e47) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e47) : "";
        int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091e46) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e46)).intValue() : 0;
        if (booleanValue9) {
            B().setVisibility(0);
            B().setTag(R.id.obfuscated_res_0x7f091e48, Long.valueOf(longValue));
            B().setTag(R.id.obfuscated_res_0x7f091e47, str3);
            B().setTag(R.id.obfuscated_res_0x7f091e46, Integer.valueOf(intValue));
        } else {
            B().setVisibility(8);
        }
        if (sparseArray.get(R.id.obfuscated_res_0x7f091e84) instanceof Boolean) {
            z3 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e84)).booleanValue();
            if (this.w.getPageActivity() instanceof NewSubPbActivity) {
                NewSubPbActivity newSubPbActivity = (NewSubPbActivity) this.w.getPageActivity();
                if (z3 && newSubPbActivity.b3() != null && newSubPbActivity.b3().m0() != null && newSubPbActivity.b3().m0().l() != null && !newSubPbActivity.b3().m0().l().isBjh()) {
                    z3 = true;
                }
            }
            booleanValue = !(sparseArray.get(R.id.obfuscated_res_0x7f091e85) instanceof Boolean) ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e85)).booleanValue() : false;
            if (!z3) {
                i2 = 0;
                w().setVisibility(0);
                i3 = 8;
            } else {
                i2 = 0;
                i3 = 8;
                w().setVisibility(8);
            }
            if (!booleanValue) {
                E().setVisibility(i2);
            } else {
                E().setVisibility(i3);
            }
            if (z3 && !booleanValue) {
                t().setVisibility(i2);
            } else {
                t().setVisibility(i3);
            }
            v().setVisibility(i3);
            if (z2) {
                u().setVisibility(i3);
                z().setVisibility(i3);
                D().setVisibility(i3);
            }
            if (UbsABTestHelper.isPBPlanA()) {
                if (postData != null) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e65, postData);
                    C().setTag(sparseArray7);
                    C().setText(R.string.obfuscated_res_0x7f0f008a);
                    C().setVisibility(0);
                }
                if (postData != null) {
                    SparseArray sparseArray8 = new SparseArray();
                    sparseArray8.put(R.id.obfuscated_res_0x7f091e65, postData);
                    sparseArray8.put(R.id.obfuscated_res_0x7f091e62, Boolean.valueOf(!postData.l0));
                    F().setTag(sparseArray8);
                    F().setText(R.string.obfuscated_res_0x7f0f008b);
                    C().setVisibility(0);
                }
                if (postData.q() != null) {
                    boolean z4 = postData.q().hasAgree;
                    int r = postData.r();
                    if (z4 && r == 5) {
                        string = this.w.getString(R.string.obfuscated_res_0x7f0f0085);
                    } else {
                        string = this.w.getString(R.string.obfuscated_res_0x7f0f0087);
                    }
                    SparseArray sparseArray9 = new SparseArray();
                    sparseArray9.put(R.id.obfuscated_res_0x7f091e49, postData);
                    v().setTag(sparseArray9);
                    v().setVisibility(0);
                    v().setText(string);
                }
            }
            lw7.l(this.t, postData, hr7Var);
        }
        z3 = false;
        if (!(sparseArray.get(R.id.obfuscated_res_0x7f091e85) instanceof Boolean)) {
        }
        if (!z3) {
        }
        if (!booleanValue) {
        }
        if (z3) {
        }
        t().setVisibility(i3);
        v().setVisibility(i3);
        if (z2) {
        }
        if (UbsABTestHelper.isPBPlanA()) {
        }
        lw7.l(this.t, postData, hr7Var);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            a aVar = new a(this);
            if (UbsABTestHelper.isPBPlanA()) {
                j(null, new String[]{this.w.getString(R.string.obfuscated_res_0x7f0f008a), this.w.getString(R.string.obfuscated_res_0x7f0f008b), this.w.getString(R.string.obfuscated_res_0x7f0f0087), this.w.getString(R.string.obfuscated_res_0x7f0f0c63), this.w.getString(R.string.obfuscated_res_0x7f0f10a1), this.w.getString(R.string.obfuscated_res_0x7f0f10a2), this.w.getString(R.string.obfuscated_res_0x7f0f043b), this.w.getString(R.string.obfuscated_res_0x7f0f0a92), this.w.getString(R.string.obfuscated_res_0x7f0f0fdb), this.w.getString(R.string.obfuscated_res_0x7f0f0496), this.w.getString(R.string.obfuscated_res_0x7f0f0b2f), this.w.getString(R.string.obfuscated_res_0x7f0f0316)}, aVar);
                this.u = x(y(0));
                this.v = x(y(1));
                this.s = x(y(2));
                this.r = x(y(3));
                this.p = x(y(4));
                this.q = x(y(5));
                this.o = x(y(6));
                this.k = x(y(7));
                this.m = x(y(8));
                this.n = x(y(9));
                this.l = x(y(10));
                this.t = x(y(11));
                return;
            }
            j(null, new String[]{this.w.getString(R.string.obfuscated_res_0x7f0f0087), this.w.getString(R.string.obfuscated_res_0x7f0f0c63), this.w.getString(R.string.obfuscated_res_0x7f0f10a1), this.w.getString(R.string.obfuscated_res_0x7f0f10a2), this.w.getString(R.string.obfuscated_res_0x7f0f043b), this.w.getString(R.string.obfuscated_res_0x7f0f0a92), this.w.getString(R.string.obfuscated_res_0x7f0f0fdb), this.w.getString(R.string.obfuscated_res_0x7f0f0496), this.w.getString(R.string.obfuscated_res_0x7f0f0b2f), this.w.getString(R.string.obfuscated_res_0x7f0f0316)}, aVar);
            this.r = x(y(1));
            this.k = x(y(5));
            this.l = x(y(8));
            this.m = x(y(6));
            this.n = x(y(7));
            this.o = x(y(4));
            this.p = x(y(2));
            this.q = x(y(3));
            this.s = x(y(0));
            this.t = x(y(9));
        }
    }

    public TextView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.t : (TextView) invokeV.objValue;
    }

    public TextView t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.o : (TextView) invokeV.objValue;
    }

    public TextView u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.n : (TextView) invokeV.objValue;
    }

    public TextView v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.s : (TextView) invokeV.objValue;
    }

    public TextView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.p : (TextView) invokeV.objValue;
    }

    public final TextView x(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view2)) == null) ? (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f6d) : (TextView) invokeL.objValue;
    }

    public View y(int i) {
        InterceptResult invokeI;
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            View view2 = this.c;
            if (view2 != null && (view2 instanceof ViewGroup) && (findViewById = view2.findViewById(R.id.obfuscated_res_0x7f0906bc)) != null && (findViewById instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) findViewById;
                int childCount = viewGroup.getChildCount();
                if (i >= 0 && i <= childCount - 1) {
                    return viewGroup.getChildAt(i);
                }
            }
            return null;
        }
        return (View) invokeI.objValue;
    }

    public TextView z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.l : (TextView) invokeV.objValue;
    }
}
