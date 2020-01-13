package com.demo.sdkforbaidudemo.view;

import com.demo.sdkforbaidudemo.ChushouSdkInit;
import com.kascend.chushou.view.homepage.HomePageRecommendFragment;
/* loaded from: classes4.dex */
public class ListFragment extends HomePageRecommendFragment {
    @Override // com.kascend.chushou.view.homepage.HomePageRecommendFragment
    public void click(String str, String str2) {
        ChushouSdkInit.testStartLiveRoom(getActivity(), str, str2);
    }
}
