package com.repackage;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.vote.WriteVoteActivity;
import com.baidu.tieba.write.write.vote.WriteVoteViewAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class yy8 implements ia5, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Intent A;
    public TbPageContext<WriteVoteActivity> a;
    public LinearLayout b;
    public NavigationBar c;
    public BdRecyclerView d;
    public WriteVoteViewAdapter e;
    public LinearLayout f;
    public LinearLayout g;
    public TextView h;
    public EditText i;
    public List<WriteVoteItemData> j;
    public WriteVoteData k;
    public ForumWriteData l;
    public String m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yy8 a;

        public a(yy8 yy8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yy8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pi.M(this.a.a.getPageActivity(), this.a.i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yy8 a;

        public b(yy8 yy8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yy8Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null) {
                return;
            }
            String obj = editable.toString();
            if (StringUtils.isNull(obj)) {
                this.a.i.setTypeface(Typeface.defaultFromStyle(0));
                this.a.y = false;
                this.a.J(false);
                return;
            }
            String replace = obj.replace(" ", "");
            if (je5.d(replace) > 40) {
                this.a.a.showToast(String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f15f5), 20));
            }
            String n = je5.n(replace, 40);
            if (!n.equals(editable.toString())) {
                this.a.i.setText(n);
                this.a.i.setSelection(n.length());
            }
            this.a.i.setTypeface(Typeface.defaultFromStyle(1));
            this.a.y = true;
            yy8 yy8Var = this.a;
            yy8Var.J(yy8Var.z);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements WriteVoteViewAdapter.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yy8 a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.e.setData(this.a.a.j);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.e.setData(this.a.a.j);
                }
            }
        }

        public c(yy8 yy8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yy8Var;
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.j.remove(i);
                this.a.d.post(new b(this));
                yy8 yy8Var = this.a;
                yy8Var.z = yy8Var.x();
                yy8 yy8Var2 = this.a;
                yy8Var2.J(yy8Var2.y && this.a.z);
            }
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.j.add(new WriteVoteItemData());
                this.a.d.post(new a(this));
                yy8 yy8Var = this.a;
                yy8Var.z = yy8Var.x();
                yy8 yy8Var2 = this.a;
                yy8Var2.J(yy8Var2.y && this.a.z);
            }
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void c(WriteVoteItemData writeVoteItemData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, writeVoteItemData, i) == null) {
                this.a.j.set(i, writeVoteItemData);
                yy8 yy8Var = this.a;
                yy8Var.z = yy8Var.x();
                yy8 yy8Var2 = this.a;
                yy8Var2.J(yy8Var2.y && this.a.z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yy8 a;

        public d(yy8 yy8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yy8Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    pi.x(this.a.a.getPageActivity(), recyclerView);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yy8 a;

        public e(yy8 yy8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yy8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                List<WriteVoteItemData> w = this.a.w();
                HashMap hashMap = new HashMap();
                int size = w.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = w.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        this.a.a.showToast(String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f15f3), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                this.a.k = new WriteVoteData();
                this.a.k.setTitle(this.a.i.getText().toString());
                this.a.k.setExpire_type(this.a.x);
                this.a.k.setIs_multi(this.a.w);
                this.a.k.setOptions(w);
                this.a.A = new Intent();
                this.a.A.putExtra(IntentConfig.WRITE_VOTE_DATA, this.a.k);
                this.a.a.getPageActivity().finish();
                yy8 yy8Var = this.a;
                yy8Var.F(yy8Var.m);
            }
        }
    }

    public yy8(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout, navigationBar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = 0;
        this.x = -1;
        this.y = false;
        this.z = false;
        this.a = tbPageContext;
        this.b = linearLayout;
        this.c = navigationBar;
        Intent intent = tbPageContext.getPageActivity().getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVoteActivityConfig.EXTRA_DATA_KEY);
            if (serializableExtra instanceof WriteVoteData) {
                this.k = (WriteVoteData) serializableExtra;
            } else if (serializableExtra instanceof ForumWriteData) {
                this.l = (ForumWriteData) serializableExtra;
            }
            this.m = intent.getStringExtra("title");
        }
        WriteVoteData writeVoteData = this.k;
        if (writeVoteData != null && !ListUtils.isEmpty(writeVoteData.getOptions()) && this.k.getOptions().size() >= 2) {
            this.j = this.k.getOptions();
        } else {
            ArrayList arrayList = new ArrayList();
            this.j = arrayList;
            arrayList.add(new WriteVoteItemData());
            this.j.add(new WriteVoteItemData());
        }
        y();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08a6, (ViewGroup) null);
            this.f = linearLayout;
            this.h = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0924a2);
            this.i = (EditText) this.f.findViewById(R.id.obfuscated_res_0x7f0924b3);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.o.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.s.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.i.addTextChangedListener(new b(this));
            this.e.h(new c(this));
            this.d.addOnScrollListener(new d(this));
            this.v.setOnClickListener(new e(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f15cb));
            TextView addTextButton = this.c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f04ef));
            this.v = addTextButton;
            addTextButton.setTextSize(0, pi.f(this.a.getPageActivity(), R.dimen.tbds44));
            this.v.setEnabled(false);
        }
    }

    public final void E() {
        WriteVoteData writeVoteData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (writeVoteData = this.k) == null) {
            return;
        }
        this.i.setText(writeVoteData.getTitle());
        this.w = this.k.getIs_multi();
        this.x = this.k.getExpire_type();
        I();
        H();
        boolean x = x();
        this.z = x;
        J(this.y && x);
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.l == null || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9).setForumWriteData(this.l).setShowVoteData(this.k).setTitle(str).send();
    }

    public final void G(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, textView, z) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.a.getResources().getDimension(R.dimen.tbds10));
            if (z) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0302);
                gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0905));
                textView.setBackgroundDrawable(gradientDrawable);
                return;
            }
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0209));
            textView.setBackgroundDrawable(gradientDrawable);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            G(this.r, this.x == -1);
            G(this.s, this.x == 1);
            G(this.t, this.x == 7);
            G(this.u, this.x == 30);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            G(this.o, this.w != 1);
            G(this.p, this.w == 1);
        }
    }

    public final void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.v.setEnabled(z);
            if (z) {
                this.v.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
            } else {
                this.v.setTextColor(sg8.a(SkinManager.getColor(R.color.CAM_X0302), 0.5f));
            }
        }
    }

    @Override // com.repackage.ia5
    public boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.ia5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.A : (Intent) invokeV.objValue;
    }

    @Override // com.repackage.ia5
    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0109);
            this.i.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.n.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.q.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (this.y && this.z) {
                this.v.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
            } else {
                this.v.setTextColor(sg8.a(SkinManager.getColor(R.color.CAM_X0302), 0.5f));
            }
            I();
            H();
            WriteVoteViewAdapter writeVoteViewAdapter = this.e;
            if (writeVoteViewAdapter != null) {
                writeVoteViewAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f0924b5) {
                this.w = 0;
                I();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0924b4) {
                this.w = 1;
                I();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0924b1) {
                this.x = -1;
                H();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0924ae) {
                this.x = 1;
                H();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0924b0) {
                this.x = 7;
                H();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0924af) {
                this.x = 30;
                H();
            }
        }
    }

    @Override // com.repackage.ia5
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            LinearLayout linearLayout = this.f;
            return linearLayout != null && this.d != null && linearLayout.getTop() == 0 && this.d.getFirstVisiblePosition() == 0;
        }
        return invokeV.booleanValue;
    }

    public final List<WriteVoteItemData> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<WriteVoteItemData> list = this.j;
            if (list == null) {
                return arrayList;
            }
            int size = list.size();
            int i = 0;
            while (i < size) {
                WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
                int i2 = i + 1;
                writeVoteItemData.setId(i2);
                writeVoteItemData.setText(this.j.get(i).getText());
                arrayList.add(writeVoteItemData);
                i = i2;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int size = this.j.size();
            for (int i = 0; i < size; i++) {
                if (StringUtils.isNull(this.j.get(i).getText())) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            BdRecyclerView bdRecyclerView = new BdRecyclerView(this.a.getPageActivity());
            this.d = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = pi.f(this.a.getPageActivity(), R.dimen.tbds27);
            this.b.addView(this.d, layoutParams);
            WriteVoteViewAdapter writeVoteViewAdapter = new WriteVoteViewAdapter(this.a);
            this.e = writeVoteViewAdapter;
            this.d.setAdapter(writeVoteViewAdapter);
            C();
            A();
            z();
            B();
            this.d.s(this.f);
            this.d.r(this.g);
            this.e.setData(this.j);
            E();
            this.i.requestFocus();
            this.i.postDelayed(new a(this), 150L);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08a5, (ViewGroup) null);
            this.g = linearLayout;
            this.n = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f092543);
            this.o = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f0924b5);
            this.p = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f0924b4);
            this.q = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f092542);
            this.r = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f0924b1);
            this.s = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f0924ae);
            this.t = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f0924b0);
            this.u = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f0924af);
        }
    }
}
