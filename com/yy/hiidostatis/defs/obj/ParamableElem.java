package com.yy.hiidostatis.defs.obj;

import android.text.TextUtils;
import com.yy.hiidostatis.inner.util.Util;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class ParamableElem implements Serializable {
    public static final String DIVIDE_PARAM = ";";
    public static final String DIVIDE_PARAM_TMP = "@@$$@@";
    public static final long serialVersionUID = 6761787877387462101L;
    public ArrayList<String> mParams = new ArrayList<>();

    public ParamableElem clearParams() {
        this.mParams.clear();
        return this;
    }

    public ArrayList<String> getParams() {
        return new ArrayList<>(this.mParams);
    }

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

    public String getConnectedParams() {
        ArrayList<String> arrayList = this.mParams;
        if (Util.empty(arrayList)) {
            return null;
        }
        if (arrayList.size() == 1) {
            return Util.replaceEncode(arrayList.get(0), DIVIDE_PARAM);
        }
        return Util.replaceEncode(TextUtils.join(DIVIDE_PARAM_TMP, arrayList.toArray(new String[arrayList.size()])), DIVIDE_PARAM).replace(DIVIDE_PARAM_TMP, DIVIDE_PARAM);
    }

    public boolean isSameParams(String... strArr) {
        if (this.mParams.isEmpty()) {
            if (strArr.length == 0) {
                return true;
            }
            return false;
        } else if (this.mParams.size() != strArr.length) {
            return false;
        } else {
            for (int i = 0; i < strArr.length; i++) {
                if (!strArr[i].equals(this.mParams.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }
}
