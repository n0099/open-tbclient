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
public class ou8 extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<pu8> a;
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

        public a(ou8 ou8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ou8Var};
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

    public ou8() {
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
    public pu8 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<pu8> list = this.a;
            if (list != null && i >= 0 && i < list.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return (pu8) invokeI.objValue;
    }

    public final void b(a aVar, View view2, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, view2, viewGroup) == null) {
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fcb);
            aVar.a = tbImageView;
            tbImageView.setIsRound(true);
            aVar.a.setDrawerType(1);
            aVar.a.setDefaultBgResource(R.color.transparent);
            aVar.a.setBorderWidth(oi.f(viewGroup.getContext(), R.dimen.obfuscated_res_0x7f070224));
            aVar.a.setConrers(15);
            aVar.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            aVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921c0);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getItem(0) != null && getItem(0).getType() == 3) {
            this.c = 0;
            this.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b0f);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && getItem(0) != null && getItem(0).getType() == 3) {
            this.c = 1;
            this.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b0d);
            notifyDataSetChanged();
        }
    }

    public void e(List<pu8> list, String str) {
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
            List<pu8> list = this.a;
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
            pu8 item = getItem(i);
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
        pu8 pu8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                aVar = new a(this);
                int itemViewType = getItemViewType(i);
                if (itemViewType == 0) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d04f9, (ViewGroup) null);
                    b(aVar, view2, viewGroup);
                    ProgressBar progressBar = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f090fda);
                    aVar.b = progressBar;
                    progressBar.setVisibility(4);
                    SkinManager.setViewTextColor(aVar.c, (int) R.color.CAM_X0101);
                } else if (itemViewType == 1) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d04f9, (ViewGroup) null);
                    b(aVar, view2, viewGroup);
                    aVar.b = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f090fda);
                    aVar.a.setDefaultResource(R.drawable.obfuscated_res_0x7f080300);
                    SkinManager.setViewTextColor(aVar.c, (int) R.color.CAM_X0101);
                } else if (itemViewType == 2) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d04f8, (ViewGroup) null);
                    b(aVar, view2, viewGroup);
                    SkinManager.setViewTextColor(aVar.c, (int) R.color.CAM_X0101);
                }
                view2.setTag(aVar);
            } else {
                aVar = (a) view2.getTag();
            }
            List<pu8> list = this.a;
            if (list != null && i >= 0 && i <= list.size() - 1 && (pu8Var = this.a.get(i)) != null) {
                int itemViewType2 = getItemViewType(i);
                if (itemViewType2 == 0) {
                    aVar.a.K(String.valueOf(pu8Var.a()), 24, false);
                    if (!TextUtils.isEmpty(pu8Var.b()) && pu8Var.b().equals(this.b)) {
                        aVar.a.setDrawBorder(true);
                    } else {
                        aVar.a.setDrawBorder(false);
                    }
                } else if (itemViewType2 == 1) {
                    MusicData musicData = (MusicData) pu8Var.c();
                    if (musicData.editMusicType == 0) {
                        aVar.a.K(musicData.img, 10, false);
                    } else {
                        aVar.a.K(String.valueOf(pu8Var.a()), 24, false);
                    }
                    if (this.c != i) {
                        aVar.b.setVisibility(4);
                    } else if (aVar.b.getVisibility() == 0) {
                        aVar.a.setDrawBorder(false);
                    }
                    if (!TextUtils.isEmpty(pu8Var.b()) && pu8Var.b().equals(this.b)) {
                        aVar.a.setDrawBorder(true);
                    } else {
                        aVar.a.setDrawBorder(false);
                    }
                } else if (itemViewType2 == 2) {
                    if (!TextUtils.isEmpty(pu8Var.b()) && pu8Var.b().equals(this.b)) {
                        aVar.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080246);
                    } else {
                        aVar.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080245);
                    }
                }
                aVar.a.setTag(pu8Var);
                aVar.a.setTag(R.id.obfuscated_res_0x7f091a12, aVar);
                aVar.a.setOnClickListener(this);
                aVar.c.setText(pu8Var.b());
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
        if ((interceptable == null || interceptable.invokeL(1048588, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f090fcb && (view2.getTag() instanceof pu8)) {
            pu8 pu8Var = (pu8) view2.getTag();
            if (pu8Var.getType() == 3 && (pu8Var.c() instanceof MusicData)) {
                StatisticItem statisticItem = new StatisticItem("c12423");
                statisticItem.param("obj_id", ((MusicData) pu8Var.c()).id);
                statisticItem.param("obj_locate", this.a.indexOf(pu8Var) + 1);
                statisticItem.param("obj_source", 1);
                TiebaStatic.log(statisticItem);
                if (view2.getResources().getString(R.string.obfuscated_res_0x7f0f0b0d).equals(pu8Var.b()) && (hVar = this.d) != null) {
                    hVar.onEffectChoosed(pu8Var, view2.getTag(R.id.obfuscated_res_0x7f091a12));
                    this.c = this.a.indexOf(pu8Var);
                    this.b = pu8Var.b();
                }
                if (!TextUtils.isEmpty(pu8Var.b()) && pu8Var.b().equals(this.b)) {
                    return;
                }
                if (!pu8Var.b().equals(view2.getResources().getString(R.string.obfuscated_res_0x7f0f0b0d))) {
                    this.c = this.a.indexOf(pu8Var);
                }
            } else {
                this.c = this.a.indexOf(pu8Var);
            }
            this.b = pu8Var.b();
            notifyDataSetChanged();
            VideoEffectLayout.h hVar2 = this.d;
            if (hVar2 != null) {
                hVar2.onEffectChoosed(pu8Var, view2.getTag(R.id.obfuscated_res_0x7f091a12));
            }
        }
    }
}
