package com.kwad.sdk.collector;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.AppStatusHelper;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class FNode implements Serializable, Comparable<FNode> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FNode";
    public static HashSet<String> specialPath;
    public transient /* synthetic */ FieldHolder $fh;
    public AppStatusHelper.AppRunningInfo appRunningInfo;
    public ArrayList<FNode> children;
    public NodeFilter externalFilter;
    public HashMap<String, Object> infoMap;
    public FChildNodeInfo nodeInfo;
    public FNode parent;
    public File realFile;

    /* loaded from: classes7.dex */
    public static class FChildNodeInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1544029961328446275L;
        public transient /* synthetic */ FieldHolder $fh;
        public long totalSize;

        public FChildNodeInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void add(@NonNull FChildNodeInfo fChildNodeInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fChildNodeInfo) == null) {
                this.totalSize += fChildNodeInfo.totalSize;
            }
        }

        public long getTotalSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.totalSize : invokeV.longValue;
        }

        public void setTotalSize(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                this.totalSize = j;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "ChildrenInfo{totalSize=" + this.totalSize + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(939652720, "Lcom/kwad/sdk/collector/FNode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(939652720, "Lcom/kwad/sdk/collector/FNode;");
                return;
            }
        }
        specialPath = new HashSet<>();
    }

    public FNode(@Nullable FNode fNode, File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fNode, file};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.children = new ArrayList<>();
        this.infoMap = new HashMap<>();
        this.nodeInfo = null;
        this.parent = fNode;
        this.realFile = file;
    }

    public static boolean isAllMatchPath(FNode fNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, fNode)) == null) {
            if (fNode == null || fNode.getNodePath() == null) {
                return false;
            }
            return specialPath.contains(fNode.getNodeFileName());
        }
        return invokeL.booleanValue;
    }

    private boolean onFilterChild(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, file)) == null) {
            if (file == null || !file.exists() || file.lastModified() > System.currentTimeMillis() + 300000) {
                return false;
            }
            NodeFilter nodeFilter = this.externalFilter;
            if (nodeFilter != null) {
                return nodeFilter.onFilterChild(file);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private void readNodeInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            File file = this.realFile;
            this.infoMap.put("path", file.getAbsolutePath());
            this.infoMap.put("lastModified", Long.valueOf(file.lastModified()));
            this.infoMap.put("fileSize", Long.valueOf(file.isFile() ? file.length() : -1L));
        }
    }

    private void sortChildren(List<FNode> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        Collections.sort(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(FNode fNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fNode)) == null) ? getRealFile().getName().compareTo(fNode.getRealFile().getName()) : invokeL.intValue;
    }

    public List<String> dumpNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(toString());
            ArrayList<FNode> arrayList2 = this.children;
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator<FNode> it = this.children.iterator();
                while (it.hasNext()) {
                    arrayList.addAll(it.next().dumpNode());
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || FNode.class != obj.getClass()) {
                return false;
            }
            return this.realFile.getAbsolutePath().equals(((FNode) obj).realFile.getAbsolutePath());
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public AppStatusHelper.AppRunningInfo getAppRunningInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AppStatusHelper.AppRunningInfo appRunningInfo = this.appRunningInfo;
            if (appRunningInfo != null) {
                return appRunningInfo;
            }
            FNode fNode = this.parent;
            if (fNode != null) {
                return fNode.getAppRunningInfo();
            }
            return null;
        }
        return (AppStatusHelper.AppRunningInfo) invokeV.objValue;
    }

    public List<FNode> getChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.children : (List) invokeV.objValue;
    }

    public NodeFilter getExternalFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.externalFilter : (NodeFilter) invokeV.objValue;
    }

    public FChildNodeInfo getFNodeInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.nodeInfo : (FChildNodeInfo) invokeV.objValue;
    }

    @Nullable
    public String getNodeFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            File file = this.realFile;
            if (file == null || !file.exists()) {
                return null;
            }
            return this.realFile.getName();
        }
        return (String) invokeV.objValue;
    }

    public long getNodeLastModifyTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            File file = this.realFile;
            if (file == null || !file.exists()) {
                return -1L;
            }
            return this.realFile.lastModified();
        }
        return invokeV.longValue;
    }

    @Nullable
    public String getNodePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            File file = this.realFile;
            if (file == null || !file.exists()) {
                return null;
            }
            return this.realFile.getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    public FNode getParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.parent : (FNode) invokeV.objValue;
    }

    public File getRealFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.realFile : (File) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.realFile.getAbsolutePath().hashCode() : invokeV.intValue;
    }

    public boolean isRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.parent == null : invokeV.booleanValue;
    }

    public boolean nodeChange(FNode fNode) {
        InterceptResult invokeL;
        String nodePath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, fNode)) == null) {
            if (fNode == null || (nodePath = fNode.getNodePath()) == null || getNodePath() == null || !nodePath.equals(getNodePath())) {
                return false;
            }
            return (((getNodeLastModifyTime() > fNode.getNodeLastModifyTime() ? 1 : (getNodeLastModifyTime() == fNode.getNodeLastModifyTime() ? 0 : -1)) == 0) && this.children.size() == fNode.children.size()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void readNode() {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            FChildNodeInfo fChildNodeInfo = new FChildNodeInfo();
            if (this.realFile.isFile()) {
                j = this.realFile.length();
            } else {
                File[] listFiles = this.realFile.listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (onFilterChild(file)) {
                            FNode fNode = new FNode(this, file);
                            fNode.readNodeInfo();
                            fNode.readNode();
                            FChildNodeInfo fNodeInfo = fNode.getFNodeInfo();
                            if (fNodeInfo != null) {
                                fChildNodeInfo.add(fNodeInfo);
                            }
                            NodeFilter nodeFilter = this.externalFilter;
                            if (nodeFilter != null) {
                                nodeFilter.onChildNodeCreate(fNode);
                            }
                            this.children.add(fNode);
                        }
                    }
                    sortChildren(this.children);
                    this.nodeInfo = fChildNodeInfo;
                }
                j = 0;
            }
            fChildNodeInfo.setTotalSize(j);
            this.nodeInfo = fChildNodeInfo;
        }
    }

    public void setAppRunningInfo(AppStatusHelper.AppRunningInfo appRunningInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, appRunningInfo) == null) {
            this.appRunningInfo = appRunningInfo;
        }
    }

    public void setExternalFilter(NodeFilter nodeFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, nodeFilter) == null) {
            this.externalFilter = nodeFilter;
        }
    }

    public void setFNodeInfo(FChildNodeInfo fChildNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, fChildNodeInfo) == null) {
            this.nodeInfo = fChildNodeInfo;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return "FNode{realFile=" + this.realFile + ", nodeInfo=" + this.nodeInfo + '}';
        }
        return (String) invokeV.objValue;
    }
}
