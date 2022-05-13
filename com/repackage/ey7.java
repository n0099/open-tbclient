package com.repackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ey7 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View.OnClickListener b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public ThreadData g;
    public boolean h;
    public boolean i;
    public String j;
    public int k;
    public View.OnLongClickListener l;
    public View.OnClickListener m;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public View b;
        public TextView c;
        public View d;

        public a(Context context, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 3;
            this.d = view2;
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f0907f4);
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905dc);
            this.c = textView;
            textView.setTextSize(0, TbConfig.getContentSizeOfLzl());
            a(TbadkCoreApplication.getInst().getSkinType());
        }

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != this.a) {
                    SkinManager.setBackgroundColor(this.b, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
                    SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
                    this.c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(i, (int) R.drawable.icon_floor_arrow_n), (Drawable) null);
                }
                this.a = i;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public View b;
        public LinearLayout c;
        public TextView d;
        public TbRichTextView e;
        public View f;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 3;
        }
    }

    public ey7(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = false;
        this.e = false;
        this.f = true;
        this.h = false;
        this.i = false;
        this.j = "";
        this.k = -1;
        this.l = null;
        this.m = null;
        this.a = context;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d05fe, (ViewGroup) null);
            inflate.setTag(new a(this.a, inflate));
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = new b();
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d05ff, (ViewGroup) null);
            bVar.b = inflate;
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e0a);
            bVar.c = linearLayout;
            if (this.h) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.topMargin = mi.f(this.a, R.dimen.obfuscated_res_0x7f070305);
                layoutParams.bottomMargin = mi.f(this.a, R.dimen.obfuscated_res_0x7f070305);
                bVar.c.setLayoutParams(layoutParams);
            }
            bVar.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091390);
            bVar.e = (TbRichTextView) inflate.findViewById(R.id.obfuscated_res_0x7f091576);
            bVar.f = inflate.findViewById(R.id.obfuscated_res_0x7f0907d9);
            bVar.e.getLayoutStrategy().t();
            if (!this.h) {
                bVar.e.getLayoutStrategy().o(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
                bVar.e.getLayoutStrategy().j(0);
                bVar.e.getLayoutStrategy().l(mi.f(this.a, R.dimen.tbds20));
                bVar.e.getLayoutStrategy().m(mi.f(this.a, R.dimen.tbds14));
                bVar.e.setMaxLines(4);
                bVar.e.setTextEllipsize(TextUtils.TruncateAt.END);
                bVar.e.setAddTruncateListener(true);
                bVar.e.setTextSize(TbConfig.getOutterSubpbContentSize());
            } else {
                bVar.e.setTextSize(TbConfig.getContentSizeOfLzl());
            }
            bVar.e.setSubPbPost(true);
            bVar.e.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
            bVar.e.setIsNeedResizeEmotion(true);
            bVar.e.setTextCenter(true);
            bVar.e.setOnClickListener(this.m);
            bVar.d.setOnClickListener(this.b);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.obfuscated_res_0x7f091ec3, bVar);
            inflate.setTag(sparseArray);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x025e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(b bVar, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        SparseArray sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, postData, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || bVar == null || postData == null) {
            return;
        }
        boolean z7 = true;
        boolean z8 = false;
        if (!postData.Y) {
            Context context = this.a;
            if (context instanceof ot7) {
                ot7 ot7Var = (ot7) context;
                postData.J0(ot7Var.getPageContext(), postData.s() != null && ot7Var.isHost(postData.s().getUserId()));
            }
        }
        if (z3) {
            SkinManager.setBackgroundColor(bVar.b, R.color.CAM_X0204);
        } else {
            bVar.b.setBackgroundResource(0);
        }
        if (postData.g0()) {
            bVar.f.setVisibility(0);
        } else {
            bVar.f.setVisibility(8);
        }
        bVar.e.setPadding(0, 0, 0, 0);
        if (postData.s() != null) {
            String name_show = postData.s().getName_show();
            String userId = postData.s().getUserId();
            String portrait = postData.s().getPortrait();
            SparseArray sparseArray2 = (SparseArray) bVar.b.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.b.setTag(sparseArray2);
                bVar.e.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.obfuscated_res_0x7f091ede, name_show);
            sparseArray2.put(R.id.obfuscated_res_0x7f091edd, userId);
            sparseArray2.put(R.id.obfuscated_res_0x7f091edc, portrait);
            sparseArray2.put(R.id.obfuscated_res_0x7f091eae, postData);
            sparseArray2.put(R.id.obfuscated_res_0x7f091ec7, Boolean.TRUE);
        }
        bVar.e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0108));
        bVar.e.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
        d(postData, this.h);
        TbRichText P = postData.P();
        if (P != null) {
            bVar.e.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d089d);
            bVar.e.setIsFromCDN(this.f);
            if (bVar.a != TbadkCoreApplication.getInst().getSkinType()) {
                P.isChanged = true;
            }
            bVar.e.setText(P);
        }
        String userId2 = postData.s().getUserId();
        int i = this.c;
        if (i != 0) {
            z4 = (i == 1002 || i == 3) ? false : true;
            z5 = (this.c == 3 || this.g.isBjh()) ? false : true;
            if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z4 = false;
            }
            if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                z4 = false;
            }
        } else {
            z4 = false;
            z5 = false;
        }
        if (this.d) {
            if (!this.g.isBjh()) {
                z5 = true;
            }
            if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z6 = true;
                if (userId2 == null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = true;
                } else {
                    z7 = z5;
                }
                bVar.d.setVisibility(8);
                sparseArray = (SparseArray) bVar.b.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bVar.b.setTag(sparseArray);
                    bVar.e.setTag(sparseArray);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091ef5, this.j);
                if (!z4) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ef0, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091ecd, Integer.valueOf(this.c));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ebb, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091ebc, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f091ebd, postData.s().getPortrait());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebe, postData.I());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ef0, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091ebe, postData.I());
                sparseArray.put(R.id.obfuscated_res_0x7f091eae, postData);
                if (!z6) {
                    if (this.g != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091f03, Boolean.TRUE);
                        sparseArray.put(R.id.obfuscated_res_0x7f091ec5, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.s() != null) {
                            sparseArray.put(R.id.obfuscated_res_0x7f091eff, postData.s().getUserId());
                            sparseArray.put(R.id.obfuscated_res_0x7f091f00, postData.s().getUserName());
                            sparseArray.put(R.id.obfuscated_res_0x7f091efe, postData.s().getName_show());
                        }
                        if (this.g.getId() != null) {
                            sparseArray.put(R.id.obfuscated_res_0x7f091f02, this.g.getId());
                        }
                        sparseArray.put(R.id.obfuscated_res_0x7f091f01, postData.I());
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f03, Boolean.FALSE);
                }
                if (!z7) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091eee, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091ecd, Integer.valueOf(this.c));
                    sparseArray.put(R.id.obfuscated_res_0x7f091eb1, Boolean.valueOf(z8));
                    sparseArray.put(R.id.obfuscated_res_0x7f091eb2, 2);
                    sparseArray.put(R.id.obfuscated_res_0x7f091eb0, postData.I());
                    sparseArray.put(R.id.obfuscated_res_0x7f091ec2, Boolean.valueOf(postData.d0()));
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091eee, Boolean.FALSE);
                }
                if (this.h && z2 && this.i) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
                    layoutParams.topMargin = mi.f(this.a, R.dimen.obfuscated_res_0x7f070207);
                    layoutParams.bottomMargin = mi.f(this.a, R.dimen.obfuscated_res_0x7f070305);
                    bVar.c.setLayoutParams(layoutParams);
                }
                if (this.h && !z2) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
                    layoutParams2.topMargin = mi.f(this.a, R.dimen.obfuscated_res_0x7f070305);
                    layoutParams2.bottomMargin = mi.f(this.a, R.dimen.obfuscated_res_0x7f070305);
                    bVar.c.setLayoutParams(layoutParams2);
                }
                bVar.d.setTag(sparseArray);
                bVar.e.setTag(sparseArray);
                bVar.a = TbadkCoreApplication.getInst().getSkinType();
                bVar.e.setOnLongClickListener(this.l);
                if (postData != null || postData.s() == null || postData.q() == null) {
                    return;
                }
                hy7.b("1", String.valueOf(postData.q().threadId), postData.s().getUserId(), postData.I(), postData.F(), postData.G());
                return;
            }
        }
        z6 = false;
        if (userId2 == null) {
        }
        z7 = z5;
        bVar.d.setVisibility(8);
        sparseArray = (SparseArray) bVar.b.getTag();
        if (sparseArray == null) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091ef5, this.j);
        if (!z4) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091ebe, postData.I());
        sparseArray.put(R.id.obfuscated_res_0x7f091eae, postData);
        if (!z6) {
        }
        if (!z7) {
        }
        if (this.h) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
            layoutParams3.topMargin = mi.f(this.a, R.dimen.obfuscated_res_0x7f070207);
            layoutParams3.bottomMargin = mi.f(this.a, R.dimen.obfuscated_res_0x7f070305);
            bVar.c.setLayoutParams(layoutParams3);
        }
        if (this.h) {
            LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
            layoutParams22.topMargin = mi.f(this.a, R.dimen.obfuscated_res_0x7f070305);
            layoutParams22.bottomMargin = mi.f(this.a, R.dimen.obfuscated_res_0x7f070305);
            bVar.c.setLayoutParams(layoutParams22);
        }
        bVar.d.setTag(sparseArray);
        bVar.e.setTag(sparseArray);
        bVar.a = TbadkCoreApplication.getInst().getSkinType();
        bVar.e.setOnLongClickListener(this.l);
        if (postData != null) {
        }
    }

    public final void d(PostData postData, boolean z) {
        TbRichText P;
        SpannableStringBuilder I;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, postData, z) == null) || postData == null || (P = postData.P()) == null) {
            return;
        }
        ArrayList<TbRichTextData> A = P.A();
        if (ListUtils.isEmpty(A)) {
            return;
        }
        if (z) {
            TbRichTextData tbRichTextData = A.get(A.size() - 1);
            int type = tbRichTextData != null ? tbRichTextData.getType() : -1;
            if (type == 1) {
                String str2 = "   " + StringHelper.getFormatTime(postData.X());
                if (A.size() > 1) {
                    if ((A.get(A.size() + (-2)) != null ? A.get(A.size() - 2).getType() : -1) != type) {
                        str2 = StringHelper.getFormatTime(postData.X());
                    }
                }
                SpannableStringBuilder I2 = tbRichTextData.I();
                if (P.hasAppendTime && I2 != 0 && P.appendLength <= I2.length()) {
                    I2.delete(I2.length() - P.appendLength, I2.length());
                }
                str = StringHelper.forceLToR(str2);
                if (I2 != null) {
                    I2.append((CharSequence) str);
                }
                P.hasAppendTime = true;
                P.appendLength = str.length();
            } else if (P.hasAppendTime) {
                str = "";
            } else {
                String formatTime = StringHelper.getFormatTime(postData.X());
                tbRichTextData = new TbRichTextData(1);
                String forceLToR = StringHelper.forceLToR(formatTime);
                tbRichTextData.z(forceLToR);
                P.hasAppendTime = true;
                P.appendLength = forceLToR.length();
                A.add(tbRichTextData);
                str = forceLToR;
            }
            SpannableStringBuilder I3 = tbRichTextData.I();
            if (I3 == null || str.length() > I3.length()) {
                return;
            }
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109));
            I3.setSpan(absoluteSizeSpan, I3.length() - str.length(), I3.length(), 33);
            I3.setSpan(foregroundColorSpan, I3.length() - str.length(), I3.length(), 33);
            return;
        }
        TbRichTextData tbRichTextData2 = A.get(A.size() - 1);
        if (P.hasAppendTime && tbRichTextData2 != null && (I = tbRichTextData2.I()) != null && P.appendLength <= I.length()) {
            I.delete(I.length() - P.appendLength, I.length());
        }
        P.hasAppendTime = false;
        P.appendLength = 0;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f = z;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.j = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view2, viewGroup)) == null) {
            PostData postData = getItem(i) instanceof PostData ? (PostData) getItem(i) : null;
            if (view2 == null) {
                if (postData.getType() == PostData.C0) {
                    view2 = a();
                } else {
                    view2 = b();
                }
            }
            if ((view2.getTag() instanceof a) && postData.getType() != PostData.C0) {
                view2 = b();
            }
            if ((view2.getTag() instanceof SparseArray) && postData.getType() == PostData.C0) {
                view2 = a();
            }
            if ((view2.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091ec3)) != null && postData != null) {
                boolean z = !this.e && i + 1 >= getCount();
                boolean z2 = i == this.k;
                c(bVar, postData, !z, i == 0, z2);
                if (z2) {
                    this.k = -1;
                }
            }
            if (view2.getTag() instanceof a) {
                ((a) view2.getTag()).a(TbadkCoreApplication.getInst().getSkinType());
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.b = onClickListener;
        }
    }

    public void i(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, threadData) == null) {
            this.g = threadData;
        }
    }

    public void j(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.c = i;
            this.d = z;
        }
    }
}
