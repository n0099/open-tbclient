package com.repackage;

import com.baidu.tbadk.core.data.ErrorData;
import java.util.List;
/* loaded from: classes5.dex */
public interface ag8 {
    void onError(String str, ErrorData errorData);

    void onNoData(ErrorData errorData);

    void onSucc(String str, List<String> list, List<ro> list2);
}
