package com.repackage;

import com.baidu.tbadk.core.data.ErrorData;
import java.util.List;
/* loaded from: classes7.dex */
public interface ya6 {
    void onError(String str, ErrorData errorData);

    void onNoData(ErrorData errorData);

    void onSucc(String str, List<String> list, List<nn> list2);
}
