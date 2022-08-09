package com.repackage;

import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.model.data.SearchResultBean;
import java.util.List;
/* loaded from: classes5.dex */
public interface a90 {
    void A(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2);

    void b(int i);

    void b0(List<? extends LiveRoomEntity> list);

    void c();

    void f0();

    void h(b90 b90Var);

    void j(List<String> list);

    void k(SearchResultBean searchResultBean);

    void o0(List<String> list);

    void showToast(String str);

    void z();
}
