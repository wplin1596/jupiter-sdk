function saveFile() {
    $.ajax({
        type: "post",
        url: "/file/save",
        data: JSON.stringify($("#fileForm").serializeJSON()),
        dataType: "json",
        contentType: "application/json",
        success: function (data) {
            if (data.result) {
                alert("添加成功");
                window.location.replace("/file/list");
            } else {
                alert(data.message);
            }
        }
    });
}

function editFile() {
    $.ajax({
        type: "post",
        url: "/file/edit",
        data: JSON.stringify($("#fileForm").serializeJSON()),
        dataType: "json",
        contentType: "application/json",
        success: function (data) {
            if (data.result) {
                alert("修改成功");
                window.location.replace("/file/list");
            } else {
                alert(data.message);
            }
        }
    });
}