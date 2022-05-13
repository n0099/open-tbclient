package com.repackage;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class tx8 extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int e;
    public transient /* synthetic */ FieldHolder $fh;
    public List<wx8> a;
    public String b;
    public int c;
    public RecordEffectLayout.i d;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public ProgressBar b;
        public TextView c;
        public int d;

        public a(tx8 tx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755275267, "Lcom/repackage/tx8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755275267, "Lcom/repackage/tx8;");
                return;
            }
        }
        e = UtilHelper.getDimenPixelSize(R.dimen.tbds156);
    }

    public tx8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public wx8 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<wx8> list = this.a;
            if (list != null && i >= 0 && i < list.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return (wx8) invokeI.objValue;
    }

    public final void b(a aVar, View view2, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, view2, viewGroup) == null) {
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fd8);
            aVar.a = tbImageView;
            tbImageView.setIsRound(true);
            aVar.a.setDrawerType(1);
            aVar.a.setDefaultBgResource(R.color.transparent);
            aVar.a.setBorderWidth(mi.f(viewGroup.getContext(), R.dimen.obfuscated_res_0x7f070224));
            aVar.a.setConrers(15);
            aVar.a.setBorderColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0302));
            aVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092217);
        }
    }

    public void c(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbMusicData) == null) || getCount() <= 1 || getItem(1) == null || getItem(1).getType() != 3) {
            return;
        }
        this.c = 1;
        this.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b1e);
        notifyDataSetChanged();
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.b = str;
        }
    }

    public void e(List<wx8> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, str) == null) {
            this.a = list;
            this.b = str;
        }
    }

    public void f(RecordEffectLayout.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iVar) == null) {
            this.d = iVar;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && getCount() > 1 && getItem(1) != null && getItem(1).getType() == 3 && (getItem(1).c() instanceof MusicData)) {
            ((MusicData) getItem(1).c()).img = str;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<wx8> list = this.a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            wx8 item = getItem(i);
            if (item == null) {
                return 0;
            }
            int type = item.getType();
            if (type != 1) {
                return type != 3 ? 0 : 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        View view3;
        wx8 wx8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                aVar = new a(this);
                int itemViewType = getItemViewType(i);
                if (itemViewType == 0) {
                    view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0175, (ViewGroup) null);
                    b(aVar, view3, viewGroup);
                    aVar.b = (ProgressBar) view3.findViewById(R.id.obfuscated_res_0x7f090fe7);
                    aVar.c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                } else if (itemViewType == 1) {
                    view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0175, (ViewGroup) null);
                    b(aVar, view3, viewGroup);
                    aVar.b = (ProgressBar) view3.findViewById(R.id.obfuscated_res_0x7f090fe7);
                    aVar.a.setDefaultResource(R.drawable.obfuscated_res_0x7f0802fe);
                    aVar.c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                } else if (itemViewType != 2) {
                    view3 = view2;
                } else {
                    view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0174, (ViewGroup) null);
                    b(aVar, view3, viewGroup);
                    aVar.c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                }
                view3.setTag(aVar);
            } else {
                aVar = (a) view2.getTag();
                view3 = view2;
            }
            List<wx8> list = this.a;
            if (list != null && i >= 0 && i <= list.size() - 1 && (wx8Var = this.a.get(i)) != null) {
                int itemViewType2 = getItemViewType(i);
                if (itemViewType2 == 0) {
                    QmFilterItem qmFilterItem = (QmFilterItem) wx8Var.c();
                    if ("-1".equals(qmFilterItem.id)) {
                        TbImageView tbImageView = aVar.a;
                        String str = qmFilterItem.bgurl;
                        int i2 = e;
                        tbImageView.H(str, 24, i2, i2, false);
                    } else {
                        TbImageView tbImageView2 = aVar.a;
                        String str2 = qmFilterItem.bgurl;
                        int i3 = e;
                        tbImageView2.H(str2, 10, i3, i3, false);
                    }
                    if (!TextUtils.isEmpty(qmFilterItem.id) && qmFilterItem.id.equals(this.b)) {
                        aVar.a.setDrawBorder(true);
                    } else {
                        aVar.a.setDrawBorder(false);
                    }
                    if (qmFilterItem.isDownLoading) {
                        aVar.b.setVisibility(0);
                    } else {
                        aVar.b.setVisibility(4);
                    }
                    if (this.c != i) {
                        aVar.b.setVisibility(4);
                    } else if (aVar.b.getVisibility() == 0) {
                        aVar.a.setDrawBorder(false);
                    }
                    aVar.c.setText(wx8Var.b());
                } else if (itemViewType2 == 1) {
                    MusicData musicData = (MusicData) wx8Var.c();
                    int i4 = musicData.editMusicType;
                    if (i4 != 0 && (i4 != 2 || TextUtils.isEmpty(musicData.img))) {
                        TbImageView tbImageView3 = aVar.a;
                        String valueOf = String.valueOf(wx8Var.a());
                        int i5 = e;
                        tbImageView3.H(valueOf, 24, i5, i5, false);
                    } else {
                        TbImageView tbImageView4 = aVar.a;
                        String str3 = musicData.img;
                        int i6 = e;
                        tbImageView4.H(str3, 10, i6, i6, false);
                    }
                    if (!TextUtils.isEmpty(wx8Var.b()) && wx8Var.b().equals(this.b)) {
                        aVar.a.setDrawBorder(true);
                    } else {
                        aVar.a.setDrawBorder(false);
                    }
                    if (this.c != i) {
                        aVar.b.setVisibility(4);
                    } else if (aVar.b.getVisibility() == 0) {
                        aVar.a.setDrawBorder(false);
                    }
                    aVar.c.setText(musicData.name);
                } else if (itemViewType2 == 2) {
                    if (!TextUtils.isEmpty(wx8Var.b()) && wx8Var.b().equals(this.b)) {
                        aVar.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080246);
                    } else {
                        aVar.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080245);
                    }
                    aVar.c.setText(wx8Var.b());
                }
                aVar.a.setTag(wx8Var);
                aVar.a.setTag(R.id.obfuscated_res_0x7f091a64, aVar);
                aVar.a.setOnClickListener(this);
                aVar.d = i;
            }
            return view3;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        RecordEffectLayout.i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f090fd8 && (view2.getTag() instanceof wx8)) {
            wx8 wx8Var = (wx8) view2.getTag();
            if (wx8Var.getType() == 3 && (wx8Var.c() instanceof MusicData)) {
                if (view2.getResources().getString(R.string.obfuscated_res_0x7f0f0b1e).equals(wx8Var.b()) && (iVar = this.d) != null) {
                    iVar.b(wx8Var, view2.getTag(R.id.obfuscated_res_0x7f091a64));
                    this.c = this.a.indexOf(wx8Var);
                    this.b = wx8Var.b();
                }
                if (!TextUtils.isEmpty(wx8Var.b()) && wx8Var.b().equals(this.b)) {
                    return;
                }
                if (!wx8Var.b().equals(view2.getResources().getString(R.string.obfuscated_res_0x7f0f0b1e))) {
                    this.c = this.a.indexOf(wx8Var);
                }
            } else {
                this.c = this.a.indexOf(wx8Var);
            }
            if (wx8Var.getType() == 2 && (wx8Var.c() instanceof QmFilterItem)) {
                this.b = ((QmFilterItem) wx8Var.c()).id;
            } else {
                this.b = wx8Var.b();
            }
            notifyDataSetChanged();
            RecordEffectLayout.i iVar2 = this.d;
            if (iVar2 != null) {
                iVar2.b(wx8Var, view2.getTag(R.id.obfuscated_res_0x7f091a64));
            }
        }
    }
}
