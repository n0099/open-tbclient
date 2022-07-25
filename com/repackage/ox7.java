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
public class ox7 extends BaseAdapter {
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
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f0907c8);
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905b7);
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

    public ox7(Context context) {
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
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0617, (ViewGroup) null);
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
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0618, (ViewGroup) null);
            bVar.b = inflate;
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e53);
            bVar.c = linearLayout;
            if (this.h) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.topMargin = pi.f(this.a, R.dimen.obfuscated_res_0x7f070302);
                layoutParams.bottomMargin = pi.f(this.a, R.dimen.obfuscated_res_0x7f070302);
                bVar.c.setLayoutParams(layoutParams);
            }
            bVar.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0913cb);
            bVar.e = (TbRichTextView) inflate.findViewById(R.id.obfuscated_res_0x7f0915aa);
            bVar.f = inflate.findViewById(R.id.obfuscated_res_0x7f0907ad);
            bVar.e.getLayoutStrategy().t();
            if (!this.h) {
                bVar.e.getLayoutStrategy().o(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
                bVar.e.getLayoutStrategy().j(0);
                bVar.e.getLayoutStrategy().l(pi.f(this.a, R.dimen.tbds20));
                bVar.e.getLayoutStrategy().m(pi.f(this.a, R.dimen.tbds14));
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
            sparseArray.put(R.id.obfuscated_res_0x7f091f06, bVar);
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
            if (context instanceof ws7) {
                ws7 ws7Var = (ws7) context;
                postData.N0(ws7Var.getPageContext(), postData.s() != null && ws7Var.G(postData.s().getUserId()));
            }
        }
        if (z3) {
            SkinManager.setBackgroundColor(bVar.b, R.color.CAM_X0204);
        } else {
            bVar.b.setBackgroundResource(0);
        }
        if (postData.j0()) {
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
            sparseArray2.put(R.id.obfuscated_res_0x7f091f21, name_show);
            sparseArray2.put(R.id.obfuscated_res_0x7f091f20, userId);
            sparseArray2.put(R.id.obfuscated_res_0x7f091f1f, portrait);
            sparseArray2.put(R.id.obfuscated_res_0x7f091ef1, postData);
            sparseArray2.put(R.id.obfuscated_res_0x7f091f0a, Boolean.TRUE);
        }
        bVar.e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0108));
        bVar.e.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
        d(postData, this.h);
        TbRichText Q = postData.Q();
        if (Q != null) {
            bVar.e.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d08b9);
            bVar.e.setIsFromCDN(this.f);
            if (bVar.a != TbadkCoreApplication.getInst().getSkinType()) {
                Q.isChanged = true;
            }
            bVar.e.setText(Q);
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
                sparseArray.put(R.id.obfuscated_res_0x7f091f39, this.j);
                if (!z4) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f34, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091f10, Integer.valueOf(this.c));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091efe, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091eff, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f091f00, postData.s().getPortrait());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f091f01, postData.J());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f34, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091f01, postData.J());
                sparseArray.put(R.id.obfuscated_res_0x7f091ef1, postData);
                if (!z6) {
                    if (this.g != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091f48, Boolean.TRUE);
                        sparseArray.put(R.id.obfuscated_res_0x7f091f08, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.s() != null) {
                            sparseArray.put(R.id.obfuscated_res_0x7f091f44, postData.s().getUserId());
                            sparseArray.put(R.id.obfuscated_res_0x7f091f45, postData.s().getUserName());
                            sparseArray.put(R.id.obfuscated_res_0x7f091f43, postData.s().getName_show());
                        }
                        if (this.g.getId() != null) {
                            sparseArray.put(R.id.obfuscated_res_0x7f091f47, this.g.getId());
                        }
                        sparseArray.put(R.id.obfuscated_res_0x7f091f46, postData.J());
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f48, Boolean.FALSE);
                }
                if (!z7) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f32, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091f10, Integer.valueOf(this.c));
                    sparseArray.put(R.id.obfuscated_res_0x7f091ef4, Boolean.valueOf(z8));
                    sparseArray.put(R.id.obfuscated_res_0x7f091ef5, 2);
                    sparseArray.put(R.id.obfuscated_res_0x7f091ef3, postData.J());
                    sparseArray.put(R.id.obfuscated_res_0x7f091f05, Boolean.valueOf(postData.g0()));
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f32, Boolean.FALSE);
                }
                if (this.h && z2 && this.i) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
                    layoutParams.topMargin = pi.f(this.a, R.dimen.obfuscated_res_0x7f070207);
                    layoutParams.bottomMargin = pi.f(this.a, R.dimen.obfuscated_res_0x7f070302);
                    bVar.c.setLayoutParams(layoutParams);
                }
                if (this.h && !z2) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
                    layoutParams2.topMargin = pi.f(this.a, R.dimen.obfuscated_res_0x7f070302);
                    layoutParams2.bottomMargin = pi.f(this.a, R.dimen.obfuscated_res_0x7f070302);
                    bVar.c.setLayoutParams(layoutParams2);
                }
                bVar.d.setTag(sparseArray);
                bVar.e.setTag(sparseArray);
                bVar.a = TbadkCoreApplication.getInst().getSkinType();
                bVar.e.setOnLongClickListener(this.l);
                if (postData != null || postData.s() == null || postData.p() == null) {
                    return;
                }
                rx7.b("1", String.valueOf(postData.p().threadId), postData.s().getUserId(), postData.J(), postData.G(), postData.H());
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
        sparseArray.put(R.id.obfuscated_res_0x7f091f39, this.j);
        if (!z4) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091f01, postData.J());
        sparseArray.put(R.id.obfuscated_res_0x7f091ef1, postData);
        if (!z6) {
        }
        if (!z7) {
        }
        if (this.h) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
            layoutParams3.topMargin = pi.f(this.a, R.dimen.obfuscated_res_0x7f070207);
            layoutParams3.bottomMargin = pi.f(this.a, R.dimen.obfuscated_res_0x7f070302);
            bVar.c.setLayoutParams(layoutParams3);
        }
        if (this.h) {
            LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
            layoutParams22.topMargin = pi.f(this.a, R.dimen.obfuscated_res_0x7f070302);
            layoutParams22.bottomMargin = pi.f(this.a, R.dimen.obfuscated_res_0x7f070302);
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
        TbRichText Q;
        SpannableStringBuilder K;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, postData, z) == null) || postData == null || (Q = postData.Q()) == null) {
            return;
        }
        ArrayList<TbRichTextData> C = Q.C();
        if (ListUtils.isEmpty(C)) {
            return;
        }
        if (z) {
            TbRichTextData tbRichTextData = C.get(C.size() - 1);
            int type = tbRichTextData != null ? tbRichTextData.getType() : -1;
            if (type == 1) {
                String str2 = "   " + StringHelper.getFormatTime(postData.Y());
                if (C.size() > 1) {
                    if ((C.get(C.size() + (-2)) != null ? C.get(C.size() - 2).getType() : -1) != type) {
                        str2 = StringHelper.getFormatTime(postData.Y());
                    }
                }
                SpannableStringBuilder K2 = tbRichTextData.K();
                if (Q.hasAppendTime && K2 != 0 && Q.appendLength <= K2.length()) {
                    K2.delete(K2.length() - Q.appendLength, K2.length());
                }
                str = StringHelper.forceLToR(str2);
                if (K2 != null) {
                    K2.append((CharSequence) str);
                }
                Q.hasAppendTime = true;
                Q.appendLength = str.length();
            } else if (Q.hasAppendTime) {
                str = "";
            } else {
                String formatTime = StringHelper.getFormatTime(postData.Y());
                tbRichTextData = new TbRichTextData(1);
                String forceLToR = StringHelper.forceLToR(formatTime);
                tbRichTextData.B(forceLToR);
                Q.hasAppendTime = true;
                Q.appendLength = forceLToR.length();
                C.add(tbRichTextData);
                str = forceLToR;
            }
            SpannableStringBuilder K3 = tbRichTextData.K();
            if (K3 == null || str.length() > K3.length()) {
                return;
            }
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109));
            K3.setSpan(absoluteSizeSpan, K3.length() - str.length(), K3.length(), 33);
            K3.setSpan(foregroundColorSpan, K3.length() - str.length(), K3.length(), 33);
            return;
        }
        TbRichTextData tbRichTextData2 = C.get(C.size() - 1);
        if (Q.hasAppendTime && tbRichTextData2 != null && (K = tbRichTextData2.K()) != null && Q.appendLength <= K.length()) {
            K.delete(K.length() - Q.appendLength, K.length());
        }
        Q.hasAppendTime = false;
        Q.appendLength = 0;
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
                if (postData.getType() == PostData.F0) {
                    view2 = a();
                } else {
                    view2 = b();
                }
            }
            if ((view2.getTag() instanceof a) && postData.getType() != PostData.F0) {
                view2 = b();
            }
            if ((view2.getTag() instanceof SparseArray) && postData.getType() == PostData.F0) {
                view2 = a();
            }
            if ((view2.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091f06)) != null && postData != null) {
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
