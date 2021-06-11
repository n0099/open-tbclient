package com.yy.hiidostatis.defs.obj;

import android.text.TextUtils;
import com.yy.hiidostatis.inner.util.Util;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ParamableElem implements Serializable {
    public static final String DIVIDE_PARAM = ";";
    public static final String DIVIDE_PARAM_TMP = "@@$$@@";
    public static final long serialVersionUID = 6761787877387462101L;
    public ArrayList<String> mParams = new ArrayList<>();

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ArrayList<String> arrayList = (ArrayList) objectInputStream.readObject();
        this.mParams = arrayList;
        if (arrayList == null) {
            this.mParams = new ArrayList<>();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.mParams);
    }

    public ParamableElem addParam(String str) {
        this.mParams.add(Util.asEmptyOnNull(str));
        return this;
    }

    public ParamableElem addParams(List<String> list) {
        this.mParams.addAll(list);
        return this;
    }

    public ParamableElem clearParams() {
        this.mParams.clear();
        return this;
    }

    public String getConnectedParams() {
        ArrayList<String> arrayList = this.mParams;
        if (Util.empty(arrayList)) {
            return null;
        }
        if (arrayList.size() == 1) {
            return Util.replaceEncode(arrayList.get(0), ";");
        }
        return Util.replaceEncode(TextUtils.join(DIVIDE_PARAM_TMP, arrayList.toArray(new String[arrayList.size()])), ";").replace(DIVIDE_PARAM_TMP, ";");
    }

    public ArrayList<String> getParams() {
        return new ArrayList<>(this.mParams);
    }

    public boolean isSameParams(String... strArr) {
        if (this.mParams.isEmpty()) {
            return strArr.length == 0;
        } else if (this.mParams.size() != strArr.length) {
            return false;
        } else {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (!strArr[i2].equals(this.mParams.get(i2))) {
                    return false;
                }
            }
            return true;
        }
    }
}
