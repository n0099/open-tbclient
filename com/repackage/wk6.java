package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.AlbumElement;
import tbclient.ItemGameCode;
import tbclient.ItemGameInfo;
import tbclient.ItemInfo;
import tbclient.ItemPage.DataRes;
import tbclient.RecentUpdate;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class wk6 implements f75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ItemInfo a;
    public List<AlbumElement> b;
    public ArrayList<ro> c;
    public boolean d;

    public wk6() {
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
        this.c = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
            return;
        }
        ItemInfo itemInfo = dataRes.item_info;
        this.a = itemInfo;
        if (itemInfo == null) {
            return;
        }
        this.b = dataRes.album_list;
        int i = 1;
        this.d = dataRes.has_tornado.intValue() == 1;
        ItemGameCode itemGameCode = dataRes.item_game_code;
        if (itemGameCode != null && ListUtils.getCount(itemGameCode.game_code_list) != 0) {
            ol6 ol6Var = new ol6();
            ol6Var.i(dataRes.item_game_code);
            this.c.add(ol6Var);
        }
        ItemGameInfo itemGameInfo = dataRes.item_game_info;
        if (itemGameInfo != null) {
            List<ThreadInfo> list = itemGameInfo.hot_videos;
            if (list != null && ListUtils.getCount(list) >= 3) {
                pl6 pl6Var = new pl6();
                pl6Var.g(dataRes.item_game_info.hot_videos);
                this.c.add(pl6Var);
            }
            RecentUpdate recentUpdate = dataRes.item_game_info.recent_update;
            if (recentUpdate != null && !li.isEmpty(recentUpdate.log)) {
                ql6 ql6Var = new ql6();
                ql6Var.g(dataRes.item_game_info.recent_update);
                this.c.add(ql6Var);
            }
        }
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            ml6 ml6Var = new ml6();
            ml6Var.setSupportType(BaseCardInfo.SupportType.TOP);
            this.c.add(ml6Var);
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    threadData.parser_title();
                    threadData.setPositionInFrsItemTab(i);
                    i++;
                    threadData.insertItemToTitleOrAbstractText();
                    this.c.add(threadData);
                    ml6 ml6Var2 = new ml6();
                    ml6Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    this.c.add(ml6Var2);
                }
            }
            ml6 ml6Var3 = new ml6();
            ml6Var3.g(this.a.id.intValue());
            ml6Var3.setPositionInFrsItemTab(i);
            ml6Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
            this.c.add(ml6Var3);
        }
        nl6 nl6Var = new nl6();
        nl6Var.i(dataRes.item_info);
        if (nl6Var.g()) {
            this.c.add(nl6Var);
        }
        rl6 rl6Var = new rl6();
        rl6Var.g(dataRes.recommend_item);
        this.c.add(rl6Var);
    }

    @Override // com.repackage.f75
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // com.repackage.f75
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
        }
    }
}
