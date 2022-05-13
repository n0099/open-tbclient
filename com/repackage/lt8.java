package com.repackage;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class lt8 extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<mt8> a;
    public String b;
    public int c;
    public VideoEffectLayout.h d;

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public ProgressBar b;
        public TextView c;
        public int d;

        public a(lt8 lt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lt8Var};
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

    public lt8() {
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
        this.c = -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public mt8 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<mt8> list = this.a;
            if (list != null && i >= 0 && i < list.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return (mt8) invokeI.objValue;
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
            aVar.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            aVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092217);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getItem(0) != null && getItem(0).getType() == 3) {
            this.c = 0;
            this.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b20);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && getItem(0) != null && getItem(0).getType() == 3) {
            this.c = 1;
            this.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b1e);
            notifyDataSetChanged();
        }
    }

    public void e(List<mt8> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, str) == null) {
            this.a = list;
            this.b = str;
        }
    }

    public void f(VideoEffectLayout.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
            this.d = hVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<mt8> list = this.a;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            mt8 item = getItem(i);
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
        mt8 mt8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                aVar = new a(this);
                int itemViewType = getItemViewType(i);
                if (itemViewType == 0) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d04ee, (ViewGroup) null);
                    b(aVar, view2, viewGroup);
                    ProgressBar progressBar = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f090fe7);
                    aVar.b = progressBar;
                    progressBar.setVisibility(4);
                    SkinManager.setViewTextColor(aVar.c, (int) R.color.CAM_X0101);
                } else if (itemViewType == 1) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d04ee, (ViewGroup) null);
                    b(aVar, view2, viewGroup);
                    aVar.b = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f090fe7);
                    aVar.a.setDefaultResource(R.drawable.obfuscated_res_0x7f0802fe);
                    SkinManager.setViewTextColor(aVar.c, (int) R.color.CAM_X0101);
                } else if (itemViewType == 2) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d04ed, (ViewGroup) null);
                    b(aVar, view2, viewGroup);
                    SkinManager.setViewTextColor(aVar.c, (int) R.color.CAM_X0101);
                }
                view2.setTag(aVar);
            } else {
                aVar = (a) view2.getTag();
            }
            List<mt8> list = this.a;
            if (list != null && i >= 0 && i <= list.size() - 1 && (mt8Var = this.a.get(i)) != null) {
                int itemViewType2 = getItemViewType(i);
                if (itemViewType2 == 0) {
                    aVar.a.K(String.valueOf(mt8Var.a()), 24, false);
                    if (!TextUtils.isEmpty(mt8Var.b()) && mt8Var.b().equals(this.b)) {
                        aVar.a.setDrawBorder(true);
                    } else {
                        aVar.a.setDrawBorder(false);
                    }
                } else if (itemViewType2 == 1) {
                    MusicData musicData = (MusicData) mt8Var.c();
                    if (musicData.editMusicType == 0) {
                        aVar.a.K(musicData.img, 10, false);
                    } else {
                        aVar.a.K(String.valueOf(mt8Var.a()), 24, false);
                    }
                    if (this.c != i) {
                        aVar.b.setVisibility(4);
                    } else if (aVar.b.getVisibility() == 0) {
                        aVar.a.setDrawBorder(false);
                    }
                    if (!TextUtils.isEmpty(mt8Var.b()) && mt8Var.b().equals(this.b)) {
                        aVar.a.setDrawBorder(true);
                    } else {
                        aVar.a.setDrawBorder(false);
                    }
                } else if (itemViewType2 == 2) {
                    if (!TextUtils.isEmpty(mt8Var.b()) && mt8Var.b().equals(this.b)) {
                        aVar.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080246);
                    } else {
                        aVar.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080245);
                    }
                }
                aVar.a.setTag(mt8Var);
                aVar.a.setTag(R.id.obfuscated_res_0x7f091a64, aVar);
                aVar.a.setOnClickListener(this);
                aVar.c.setText(mt8Var.b());
                aVar.d = i;
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        VideoEffectLayout.h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f090fd8 && (view2.getTag() instanceof mt8)) {
            mt8 mt8Var = (mt8) view2.getTag();
            if (mt8Var.getType() == 3 && (mt8Var.c() instanceof MusicData)) {
                StatisticItem statisticItem = new StatisticItem("c12423");
                statisticItem.param("obj_id", ((MusicData) mt8Var.c()).id);
                statisticItem.param("obj_locate", this.a.indexOf(mt8Var) + 1);
                statisticItem.param("obj_source", 1);
                TiebaStatic.log(statisticItem);
                if (view2.getResources().getString(R.string.obfuscated_res_0x7f0f0b1e).equals(mt8Var.b()) && (hVar = this.d) != null) {
                    hVar.onEffectChoosed(mt8Var, view2.getTag(R.id.obfuscated_res_0x7f091a64));
                    this.c = this.a.indexOf(mt8Var);
                    this.b = mt8Var.b();
                }
                if (!TextUtils.isEmpty(mt8Var.b()) && mt8Var.b().equals(this.b)) {
                    return;
                }
                if (!mt8Var.b().equals(view2.getResources().getString(R.string.obfuscated_res_0x7f0f0b1e))) {
                    this.c = this.a.indexOf(mt8Var);
                }
            } else {
                this.c = this.a.indexOf(mt8Var);
            }
            this.b = mt8Var.b();
            notifyDataSetChanged();
            VideoEffectLayout.h hVar2 = this.d;
            if (hVar2 != null) {
                hVar2.onEffectChoosed(mt8Var, view2.getTag(R.id.obfuscated_res_0x7f091a64));
            }
        }
    }
}
